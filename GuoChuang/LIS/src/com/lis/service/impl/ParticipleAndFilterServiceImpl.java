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
import com.lis.dao.EmotionKeywordDao;
import com.lis.model.ComplaintText;
import com.lis.model.EmotionKeyword;
import com.lis.service.ParticipleAndFilterService;

@Service("participleAndFilterService")
@Transactional
public class ParticipleAndFilterServiceImpl implements ParticipleAndFilterService{
	
	@Autowired
	private ComplaintTextDao complaintTextDao;
	@Autowired
	private EmotionKeywordDao emotionKeywordDao;
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
 
       
                        outString.add(matcher.group(1));
                       
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

	
	public List<String> getVerbs(){
		
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
            	Pattern pattern = Pattern.compile("(.+?)/v.*");
            	Matcher matcher = pattern.matcher(ss);
            	if(matcher.find() && matcher.group(1).length()>1 &&!isDigit(matcher.group(1))){
 
       
                        outString.add(matcher.group(1));
                       
            	}
            }
            
            testICTCLAS50.ICTCLAS_Exit();
            
        }catch(Exception ex){
            
        }           
        return outString;				
	}
	
    public List<String> getAdjs(){
		
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
            	Pattern pattern = Pattern.compile("(.+?)/a.*");
            	Matcher matcher = pattern.matcher(ss);
            	if(matcher.find() && matcher.group(1).length()>1 &&!isDigit(matcher.group(1))){
 
       
                        outString.add(matcher.group(1));
                       
            	}
            }
            
            testICTCLAS50.ICTCLAS_Exit();
            
        }catch(Exception ex){
            
        }           
        return outString;				
	}

    public List<String> getAdvs(){
	
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
        	Pattern pattern = Pattern.compile("(.+?)/d.*");
        	Matcher matcher = pattern.matcher(ss);
        	if(matcher.find() && matcher.group(1).length()>1 &&!isDigit(matcher.group(1))){

   
                    outString.add(matcher.group(1));
                   
        	}
        }
        
        testICTCLAS50.ICTCLAS_Exit();
        
    }catch(Exception ex){
        
    }           
    return outString;				
}

	public List<String> getVerbsFromCompContent(List<ComplaintText> list){
		
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
            	Pattern pattern = Pattern.compile("(.+?)/v.*");
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
	public List<String> getAdjsFromCompContent(List<ComplaintText> list){
		
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
            	Pattern pattern = Pattern.compile("(.+?)/a.*");
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
	public List<String> getAdvsFromCompContent(List<ComplaintText> list){
		
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
            	Pattern pattern = Pattern.compile("(.+?)/d.*");
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
	
	public List<String> getDuanYuFromCompContent(String complaintTextTemp){
		
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
            
            //for(int i = 0;i<list.size();i++){
            	//String complaintTextTemp = list.get(i).getComplaintContent();
            	//System.out.println(complaintTextTemp);
            	input.append(complaintTextTemp);
            //}

            //未导入用户词典
            byte nativeBytes[] = testICTCLAS50.ICTCLAS_ParagraphProcess(input.toString().getBytes("GB2312"), 0, 1);
                
            String nativeStr = new String(nativeBytes,0,nativeBytes.length,"GB2312");
            //System.out.println(nativeStr);
        
      
            	Pattern pattern = Pattern.compile("([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|" 
            			+"([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+");
            	Matcher matcher = pattern.matcher(nativeStr);
            	
            	while(matcher.find()){
            		String tmp = "";//保存去除/n等符号的汉字字符串
            		String ss = matcher.group();
            		if(!ss.equals("")){
                  
                        Pattern pattern1 = Pattern.compile("[\u4e00-\u9fa5]");
                        Matcher matcher1 = pattern1.matcher(ss);
                        while(matcher1.find()){
                        	if(!matcher1.group().equals("")){
                        		tmp = tmp+matcher1.group();
                        	}
                        }
                        if(!tmp.equals(""))
                        	outString.add(tmp);
            		}
            	}
   
            
            testICTCLAS50.ICTCLAS_Exit();
            
        }catch(Exception ex){
            
        }           
        return outString;				
	}
	
	public List<String> getDuanYu(){
		
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
            //System.out.println(nativeStr);
        
      
            	Pattern pattern = Pattern.compile("([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|" 
            			+"([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)+([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/a[a-z]?\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/d\\s)*([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+|"
            			+"([\u4e00-\u9fa5]+/d\\s)+([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)+([\u4e00-\u9fa5]+/a[a-z]?\\s)*([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)+");
            	Matcher matcher = pattern.matcher(nativeStr);
            	
            	while(matcher.find()){
            		String tmp = "";//保存去除/n等符号的汉字字符串
            		String ss = matcher.group();
            		if(!ss.equals("")){
                  
                        Pattern pattern1 = Pattern.compile("[\u4e00-\u9fa5]");
                        Matcher matcher1 = pattern1.matcher(ss);
                        while(matcher1.find()){
                        	if(!matcher1.group().equals("")){
                        		tmp = tmp+matcher1.group();
                        	}
                        }
                        if(!tmp.equals(""))
                        	outString.add(tmp);
            		}
            	}
   
            
            testICTCLAS50.ICTCLAS_Exit();
            
        }catch(Exception ex){
            
        }           
        return outString;				
	}

	public double getEmoScore(List<ComplaintText> list){
		
		List<String> advWord = getAdvsFromCompContent(list);
		List<EmotionKeyword>  emoWord = emotionKeywordDao.list();
		int qiang = 0;
		int zhong = 0;
		int qing = 0;
		double score = 0;
		for(int i = 0;i<advWord.size();i++){
			for(int j = 0;j<emoWord.size();j++){
				if(advWord.get(i).equals(emoWord.get(j).getEmotionKeyword())){
					if(emoWord.get(j).getEmotionDegree().equals("强烈"))
						qiang++;
					else if(emoWord.get(j).getEmotionDegree().equals("中等"))
						zhong++;
					else
						qing++;
				}
			}
		}
		score = (qiang*3+zhong*2+qing)/(qiang+zhong+qing);
		return score;
	}
	public double getEmoScore1(){
		List<ComplaintText> list = complaintTextDao.list();
		List<String> advWord = getAdvsFromCompContent(list);
		List<EmotionKeyword>  emoWord = emotionKeywordDao.list();
		int qiang = 0;
		int zhong = 0;
		int qing = 0;
		double score = 0;
		for(int i = 0;i<advWord.size();i++){
			for(int j = 0;j<emoWord.size();j++){
				
				if(advWord.get(i).equals(emoWord.get(j).getEmotionKeyword())){
					//System.out.println(emoWord.get(j).getEmotionKeyword());
					if(emoWord.get(j).getEmotionDegree().equals("强烈"))
						qiang++;
					else if(emoWord.get(j).getEmotionDegree().equals("中等"))
						zhong++;
					else
						qing++;
				}
			}
		}
		score = (qiang*3+zhong*2+qing)/(qiang+zhong+qing);
		return score;
	}
	
	public List<String> getNounAdjVerbs(){
		
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
	        
	        Pattern pattern = Pattern.compile("([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)|"
        		
        			+"([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)|([\u4e00-\u9fa5]+/a[a-z]{0,3}\\s)");
        	Matcher matcher = pattern.matcher(nativeStr);
        	
        	while(matcher.find()){
        		String tmp = "";//保存去除/n等符号的汉字字符串
        		String ss = matcher.group();
        		//System.out.println(ss);
        		if(!ss.equals("")){
              
                    Pattern pattern1 = Pattern.compile("[\u4e00-\u9fa5]");
                    Matcher matcher1 = pattern1.matcher(ss);
                    while(matcher1.find()){
                    	if(!matcher1.group().equals("")){
                    		tmp = tmp+matcher1.group();
                    		//outString.add(matcher1.group());
                    	}
                    }
                    if(!tmp.equals(""))
                    	outString.add(tmp);
        		}
        	}

	        
	        testICTCLAS50.ICTCLAS_Exit();
	        
	    }catch(Exception ex){
	        
	    }           
	    return outString;				
	}
public List<String> getNounAdjVerbs(List<ComplaintText> list){
		
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
	       // List<ComplaintText> list = complaintTextDao.list();
	        
	        for(int i = 0;i<list.size();i++){
	        	String complaintTextTemp = list.get(i).getComplaintContent();
	        	//System.out.println(complaintTextTemp);
	        	input.append(complaintTextTemp);
	        }

	        //未导入用户词典
	        byte nativeBytes[] = testICTCLAS50.ICTCLAS_ParagraphProcess(input.toString().getBytes("GB2312"), 0, 1);
	            
	        String nativeStr = new String(nativeBytes,0,nativeBytes.length,"GB2312");
	        
	        Pattern pattern = Pattern.compile("([\u4e00-\u9fa5]+/n[a-z]{0,2}\\s)|"
        		
        			+"([\u4e00-\u9fa5]+/v[a-z]{0,3}\\s)|([\u4e00-\u9fa5]+/a[a-z]{0,3}\\s)");
        	Matcher matcher = pattern.matcher(nativeStr);
        	
        	while(matcher.find()){
        		String tmp = "";//保存去除/n等符号的汉字字符串
        		String ss = matcher.group();
        		//System.out.println(ss);
        		if(!ss.equals("")){
              
                    Pattern pattern1 = Pattern.compile("[\u4e00-\u9fa5]");
                    Matcher matcher1 = pattern1.matcher(ss);
                    while(matcher1.find()){
                    	if(!matcher1.group().equals("")){
                    		tmp = tmp+matcher1.group();
                    		//outString.add(matcher1.group());
                    	}
                    }
                    if(!tmp.equals(""))
                    	outString.add(tmp);
        		}
        	}

	        
	        testICTCLAS50.ICTCLAS_Exit();
	        
	    }catch(Exception ex){
	        
	    }           
	    return outString;				
	}
}
