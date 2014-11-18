package com.lis.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lis.model.BussinessKeyword;
import com.lis.model.ComplaintText;
import com.lis.service.SegmentationService;

public class SegmentationTest {

	public ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/lis/config/spring-config.xml");
	
	public SegmentationService segmentationService = (SegmentationService) context.getBean("segmentationService");
	
	@Test
	public void testName() throws Exception {
//		//获取数据库中文本记录
		List<ComplaintText> list = segmentationService.getTextRecords("2012-10-10","2014-11-13","0101010101");
		
		for(int k = 0; k < list.size(); k++){
			System.out.println(list.get(k).getComplaintContent());
		}
//		
//		String[] keyWords = {"客户"};
//		
//		//匹配关键词，获取匹配结果
//		List<String> matchResults = segmentationService.getMatchingTexts(list, keyWords);
//		
//		for(int i = 0; i < matchResults.size(); i++){
//			System.out.println(matchResults.get(i));
//		}
//		
//		List<BussinessKeyword> keywordList = segmentationService.getBusinessKeywords();
//		for(int i = 0; i < keywordList.size();i++){
//			System.out.println("111" + keywordList.get(i).getBussinessKeyword());
//		}
//		List<ComplaintText> complaintTextList = segmentationService.getTextRecords();
//		
//		String[] keyWords = {"客户"};
//		
//		List<String> matchingComplaintTexts = segmentationService.getMatchingTexts(complaintTextList, keyWords);
//		
//		for(int i = 0; i < matchingComplaintTexts.size(); i++){
//			System.out.println(matchingComplaintTexts.get(i));
//		}
		
		
		
	}
	
}
