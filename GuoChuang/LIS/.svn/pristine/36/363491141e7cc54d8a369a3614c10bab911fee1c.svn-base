package com.lis.util;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

public class Parser {
	private BussinessCityDao businessCityDao;	
	private ServiceRequestTypeDao serviceRequestTypeDao;
	private ProblemTypeDao problemTypeDao;
	private ProblemDetailDao problemDetailDao;
	private ComplaintTextDao complaintTextDao;
	private SimpleDateFormat formatter;
	
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

	public String[] readFromFile(String filePath) throws IOException{
		InputStream inputStream = null;
		InputStream bufferInputStream = null;
		byte[] tempByte = new byte[2048];
		StringBuffer stringBuffer = new StringBuffer();
		int byteRead = 0;
		String tempString ;
		String result;
		try {
			inputStream = new FileInputStream(filePath);
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
//			for(int i = 0; i < lineLength; i++){
				line = lines[1];
				elements = pattern.split(line,12);
				for(int j = 0; j < 11 ; j++){
					System.out.println(elements[j]);
				}
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
				for(int i = 0; i < 11; i++){
					System.out.println(elements[i]);
				}
				System.out.println(content);
				System.out.println( mix[mixLength -2]);
				System.out.println( mix[mixLength -1]);
				saveComplaintText(elements, content, mix[mixLength -2], mix[mixLength - 1]);
				
//			}
			return lines;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			inputStream.close();
			bufferInputStream.close();
			inputStream = null;
			bufferInputStream = null;
			stringBuffer = null;
		}
		return null;
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
			BussinessCity bussinessCity = new BussinessCity();
			bussinessCity.setBussinessCityID(bussinessCityID);
			bussinessCity.setBussinessCityName(bussinessCityName);
			complaintText.setBussinessCityFK(bussinessCity);
			
			//解析服务类型
			String allCodeIDs = elements[5];
			String serviceRequestNameAll = elements[6];
			allCodeIDs = "01";
			serviceRequestNameAll = "服务类型";
			ServiceRequestType serviceRequestType = new ServiceRequestType();
			serviceRequestType.setAllCodeID(allCodeIDs);
			serviceRequestType.setServiceRequestName(serviceRequestNameAll);
			complaintText.setServiceRequestTypeFK(serviceRequestType);
			
			String problemTypeID = elements[7];
			String problemTypeName = elements[8];
			ProblemType problemType = new ProblemType();
			problemType.setProblemTypeID(problemTypeID);
			problemType.setProblemTypeName(problemTypeName);
			complaintText.setProblemTypeFK(problemType);
			
			String problemDetailID = elements[9];
			String problemDetailName = elements[10];
			ProblemDetail problemDetail = new ProblemDetail();
			problemDetail.setProblemDetailID(problemDetailID);
			problemDetail.setProblemDetailName(problemDetailName);
			complaintText.setProblemDetailFK(problemDetail);
			
			complaintText.setComplaintTemplate(complaintTemplate + templateValue);
			complaintText.setComplaintContent(complaintContent);
			complaintTextDao.save(complaintText);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	@Test
	public void testName() throws Exception {
		String filePath = "C:\\Users\\j\\Desktop\\test";
		File file = new File(filePath);
		if (!file.isDirectory()) {
		        System.out.println("文件");
		        System.out.println("path=" + file.getPath());
		        System.out.println("absolutepath=" + file.getAbsolutePath());
		        System.out.println("name=" + file.getName());

		} else if (file.isDirectory()) {
		        System.out.println("文件夹");
		        String[] filelist = file.list();
		        String absolutePath;
		        String fileName;
		        File file2;
		        for (int i = 0; i < filelist.length; i++) {
//                            File readfile = new File(filepath + "\\" + filelist[i]);
//                            if (!readfile.isDirectory()) {
//                                    System.out.println("path=" + readfile.getPath());
//                                    System.out.println("absolutepath="
//                                                    + readfile.getAbsolutePath());
//                                    System.out.println("name=" + readfile.getName());
//
//                            } else if (readfile.isDirectory()) {
//                                    readfile(filepath + "\\" + filelist[i]);
//                            }
		        fileName = filelist[i];
		        if(fileName.matches("(.)*txt")){
		        	absolutePath = filePath + "\\" + filelist[i];
		        	file2 = new File(absolutePath);
		        	file2.delete();
		        	System.out.println(absolutePath);
		        	
		        }
		        
//		        	System.out.println(filelist[i]);
		        }

		}
		
	}
}
