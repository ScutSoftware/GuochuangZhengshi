package com.lis.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.dao.BussinessCityDao;
import com.lis.dao.ComplaintTextDao;
import com.lis.dao.ProblemDetailDao;
import com.lis.dao.ProblemTypeDao;
import com.lis.dao.ServiceRequestTypeDao;
import com.lis.model.BussinessCity;
import com.lis.model.ComplaintText;
import com.lis.model.ProblemDetail;
import com.lis.model.ProblemType;
import com.lis.model.ServiceRequestType;
import com.lis.service.ImportFileToDatabaseService;
import com.lis.util.HQLConditionQuery;
import com.lis.util.HQLOrderBy;

@Service("importFileToDatabaseService")
@Transactional
@Component
public class ImportFileToDatabaseServiceImpl extends TimerTask implements ImportFileToDatabaseService{

	public static final String  FILE_PATH = "C:\\Users\\j\\Desktop\\test";
	private BussinessCityDao businessCityDao;	
	private ServiceRequestTypeDao serviceRequestTypeDao;
	private ProblemTypeDao problemTypeDao;
	private ProblemDetailDao problemDetailDao;
	private ComplaintTextDao complaintTextDao;
	private SimpleDateFormat formatter;
	private static int count = 20;
	
	@Autowired
	public void setBusinessCityDao(BussinessCityDao businessCityDao) {
		this.businessCityDao = businessCityDao;
	}

	@Autowired
	public void setServiceRequestTypeDao(ServiceRequestTypeDao serviceRequestTypeDao) {
		this.serviceRequestTypeDao = serviceRequestTypeDao;
	}

	@Autowired
	public void setProblemTypeDao(ProblemTypeDao problemTypeDao) {
		this.problemTypeDao = problemTypeDao;
	}

	@Autowired
	public void setProblemDetailDao(ProblemDetailDao problemDetailDao) {
		this.problemDetailDao = problemDetailDao;
	}

	@Autowired
	public void setComplaintTextDao(ComplaintTextDao complaintTextDao) {
		this.complaintTextDao = complaintTextDao;
	}
	@Override
	public void importFile(String filePath) {
		// TODO Auto-generated method stub
		InputStream inputStream = null;
		InputStream bufferInputStream = null;
		File file = new File(filePath);
		byte[] tempByte = new byte[2048];
		StringBuffer stringBuffer = new StringBuffer();
		int byteRead = 0;
		String tempString ;
		String result;
		try {
			inputStream = new FileInputStream(file);
			bufferInputStream = new BufferedInputStream(inputStream);
			
			// 当读到文件尾时，会返回-1.否则返回读取的字节数
			while((byteRead = bufferInputStream.read(tempByte)) != -1){
				
				// 将byte[]转为String，存入stringbuffer中。
				tempString = new String(tempByte, 0, byteRead);
				stringBuffer.append(tempString);
			}
			
			// 将stringBuffer转为String
			result = stringBuffer.toString();
			
			//先按照行split，获得字符串数据
			String regEx = "\n";
			Pattern pattern = Pattern.compile(regEx);
			String[] lines = pattern.split(result);
			int lineLength = lines.length;
			
			//对每一行进一步处理
			String[] elements;
			regEx = ",";
			pattern = Pattern.compile(regEx);
			String line;	//每行的字符串
			String str ; 	//包含投诉内容和最后两个内容的字符串
			String content;
			StringBuffer contentBuffer;  	//用来存投诉文本切分后的每一块
			String[] mix ; 	//混杂投诉文本和投诉模板要素和取值的数组
			int mixLength; 
//			for(int i = 550; i < 551; i++){
				line = lines[count];
				elements = pattern.split(line,12);
				str = elements[11];
				mix = pattern.split(str);
				
				//将最后混杂的字符串先切分，后混合
				contentBuffer = new StringBuffer();
				contentBuffer.append(mix[0]);
				mixLength = mix.length;
				for(int k = 1; k < mixLength - 2; k++){
					contentBuffer.append("," + mix[k]); 
				}
				content = contentBuffer.toString();
				saveComplaintText(elements, content, mix[mixLength -2], mix[mixLength - 1]);
				count++;
				
//			}
			
			//删除文件
			file.delete();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				inputStream.close();
				bufferInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			inputStream = null;
			bufferInputStream = null;
			stringBuffer = null;
		}
		
	}

	
	public void saveComplaintText(String[] elements, String complaintContent, String complaintTemplate, String templateValue) throws ParseException{
		try {
			ComplaintText complaintText = new ComplaintText();
			
			String serialNumber = elements[0];
			complaintText.setSerialNumber(serialNumber);
			
			String processTimeStr = elements[2];
			Pattern pattern = Pattern.compile(":");
			String[] str2 = pattern.split(processTimeStr,2);
			String temp = str2[0].substring(0, 2) + " " + str2[0].substring(2, 5) + " 20" + str2[0].substring(5, 7) + " ";
			String temp2 = temp + str2[1];
			this.formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss",Locale.ENGLISH);
			Date processTime = formatter.parse(temp2);
			complaintText.setProcessTime(processTime);
			
			String bussinessCityID = elements[3];
			String bussinessCityName = elements[4];
			BussinessCity bussinessCity ;
			HQLConditionQuery bussinessCondition = new HQLConditionQuery();
			bussinessCondition.add("BussinessCityID =:cityID", "cityID", bussinessCityID);
			List<HQLConditionQuery> bussinessList = new ArrayList<HQLConditionQuery>();
			bussinessList.add(bussinessCondition);
			List<BussinessCity> bussinessCityList = businessCityDao.list(bussinessList, null);
			if(bussinessCityList.size() == 0){
				bussinessCity = new BussinessCity();
				bussinessCity.setBussinessCityID(bussinessCityID);
				bussinessCity.setBussinessCityName(bussinessCityName);
			}
			else{
				bussinessCity = bussinessCityList.get(0);
			}
			
			complaintText.setBussinessCityFK(bussinessCity);
			
			//解析服务类型
			String allCodeIDs = elements[5];
			String serviceRequestNameAll = elements[6];
			allCodeIDs = "01";
			serviceRequestNameAll = "服务类型";
			
			HQLConditionQuery serviceRequestTypeCondition = new HQLConditionQuery();
			serviceRequestTypeCondition.add("allCodeID =:ID", "ID", allCodeIDs);
			List<HQLConditionQuery> serviceRequestTypeList = new ArrayList<HQLConditionQuery>();
			serviceRequestTypeList.add(serviceRequestTypeCondition);
			List<ServiceRequestType>  serviceList = serviceRequestTypeDao.list(serviceRequestTypeList, null);
			ServiceRequestType serviceRequestType = null;
			if(serviceList.size() == 0){
				serviceRequestType = new ServiceRequestType();
				serviceRequestType.setAllCodeID(allCodeIDs);
				serviceRequestType.setServiceRequestName(serviceRequestNameAll);
			}
			else{
				serviceRequestType = serviceList.get(0);
			}			
			complaintText.setServiceRequestTypeFK(serviceRequestType);
			
			String problemTypeID = elements[7];
			String problemTypeName = elements[8];
			
			HQLConditionQuery problemTypeCondition = new HQLConditionQuery();
			problemTypeCondition.add("problemTypeID =:ID", "ID", problemTypeID);
			List<HQLConditionQuery> problemTypeList = new ArrayList<HQLConditionQuery>();
			problemTypeList.add(problemTypeCondition);
			List<ProblemType>  TypeList = problemTypeDao.list(problemTypeList, null);
			ProblemType problemType = null;
			if(TypeList.size() == 0){
				problemType = new ProblemType();
				problemType.setProblemTypeID(problemTypeID);
				problemType.setProblemTypeName(problemTypeName);
			}
			else{
				problemType = TypeList.get(0);
			}			
			complaintText.setProblemTypeFK(problemType);
			
			String problemDetailID = elements[9];
			String problemDetailName = elements[10];
			HQLConditionQuery problemDetailCondition = new HQLConditionQuery();
			problemDetailCondition.add("problemDetailID =:ID", "ID", problemDetailID);
			List<HQLConditionQuery> problemDetailList = new ArrayList<HQLConditionQuery>();
			problemDetailList.add(problemDetailCondition);
			List<ProblemDetail>  detailList = problemDetailDao.list(problemDetailList, null);
			ProblemDetail problemDetail = null;
			if(detailList.size() == 0){
				problemDetail = new ProblemDetail();
				problemDetail.setProblemDetailID(problemDetailID);
				problemDetail.setProblemDetailName(problemDetailName);
			}
			else{
				problemDetail = detailList.get(0);
			}
			complaintText.setProblemDetailFK(problemDetail);
			
			complaintText.setComplaintTemplate(complaintTemplate + templateValue);
			complaintText.setComplaintContent(complaintContent);
			complaintText.setInsertTime(new Date());
			complaintTextDao.save(complaintText);
			count++;
			complaintTextDao.flush();
			complaintTextDao.clear();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}

	@Scheduled(cron = "0/5 * *  * * ?")
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("i am here");
	}

	@Override
//	@Scheduled(cron = "0 24 12 ? * MON-FRI")
	public void scanDirectory() {
		String filePath = FILE_PATH;
		File file = new File(filePath);
		if (!file.isDirectory()) {
			importFile(file.getAbsolutePath());

		} else if (file.isDirectory()) {
			String[] filelist = file.list();
			String absolutePath;
			String fileName;
			File file2;
		  	for (int i = 0; i < filelist.length; i++) {
		        fileName = filelist[i];
		        if(fileName.matches("(.)*txt")){
		        	absolutePath = filePath + "\\" + filelist[i];
		        	importFile(absolutePath);
		        }
		  	}

		}
		
		
	}
	
	
}
