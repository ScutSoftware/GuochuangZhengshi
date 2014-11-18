package com.lis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ICTCLAS.I3S.AC.ICTCLAS50;

import com.lis.dao.ComplaintTextDao;
import com.lis.model.ComplaintText;
import com.lis.service.ParticipleAndFilterService;

@Service("participleAndFilterService")
@Transactional
public class ParticipleAndFilterServiceImpl implements ParticipleAndFilterService{
	
	@Autowired
	private ComplaintTextDao complaintTextDao;
	//从数据库读取所有投诉记录，返回所有名词
	public List<String> getNouns(){
		
		List<String> outString = new ArrayList<String>();
		
		try{
            //分词系统初始化
            ICTCLAS50 testICTCLAS50 = new ICTCLAS50();
            String argu = ".";
            if(testICTCLAS50.ICTCLAS_Init(argu.getBytes("GB2312")) == false){
                System.out.println("Init Fail");
            }else{
                System.out.println("Init Succeed!");
            }
    
            StringBuffer input = new StringBuffer();
            //用于从数据库读取
            List<ComplaintText> list = complaintTextDao.list();
            
            for(int i = 0;i<list.size();i++){
            	String complaintTextTemp = list.get(i).getComplaintContent();
            	//System.out.println(complaintTextTemp);
            	input.append(complaintTextTemp);
            }

            //未导入用户词典
            byte nativeBytes[] = testICTCLAS50.ICTCLAS_ParagraphProcess(input.toString().getBytes("GB2312"), 0, 1);
                
            String nativeStr = new String(nativeBytes,0,nativeBytes.length,"GB2312");
            
            Scanner in = new Scanner(nativeStr);
            int i = 0;//行数
            while(in.hasNext()){           	
            	String ss = in.next();
                //提取名词
            	Pattern pattern = Pattern.compile("(.+?)/n.*");
            	Matcher matcher = pattern.matcher(ss);
            	if(matcher.find() && matcher.group(1).length()>1 &&!isDigit(matcher.group(1))){
 
                        //cellNew.setCellValue(matcher.group(1));
            			//写入输出List
                        outString.add(matcher.group(1));
                        //System.out.println(outString);
            	}
            }
            
            testICTCLAS50.ICTCLAS_Exit();
            
        }catch(Exception ex){
            
        }           
        return outString;				
	}
    //判断是否为数字
    private boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{1,}");
}	
    //接收投诉文本，返回所有名词
	public List<String> getNounsFromCompContent(List<ComplaintText> list){
		
		List<String> outString = new ArrayList<String>();
		
		try{
            //分词系统初始化
            ICTCLAS50 testICTCLAS50 = new ICTCLAS50();
            String argu = ".";
            if(testICTCLAS50.ICTCLAS_Init(argu.getBytes("GB2312")) == false){
                System.out.println("Init Fail");
            }else{
                System.out.println("Init Succeed!");
            }
    
            StringBuffer input = new StringBuffer();
            //用于从数据库读取
            //List<ComplaintText> list = complaintTextDao.list();
            
            for(int i = 0;i<list.size();i++){
            	String complaintTextTemp = list.get(i).getComplaintContent();
            	//System.out.println(complaintTextTemp);
            	input.append(complaintTextTemp);
            }

            //未导入用户词典
            byte nativeBytes[] = testICTCLAS50.ICTCLAS_ParagraphProcess(input.toString().getBytes("GB2312"), 0, 1);
                
            String nativeStr = new String(nativeBytes,0,nativeBytes.length,"GB2312");
            
            Scanner in = new Scanner(nativeStr);
            int i = 0;//行数
            while(in.hasNext()){           	
            	String ss = in.next();
                //提取名词
            	Pattern pattern = Pattern.compile("(.+?)/n.*");
            	Matcher matcher = pattern.matcher(ss);
            	if(matcher.find() && matcher.group(1).length()>1 &&!isDigit(matcher.group(1))){
 
                        //cellNew.setCellValue(matcher.group(1));
            			//写入输出List
                        outString.add(matcher.group(1));
                        //System.out.println(outString);
            	}
            }
            
            testICTCLAS50.ICTCLAS_Exit();
            
        }catch(Exception ex){
            
        }           
        return outString;				
	}

}
