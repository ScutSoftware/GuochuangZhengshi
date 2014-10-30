package com.lis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lis.model.ComplaintText;
import com.lis.service.SegmentationService;

public class SegmentationTest {

	public ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/lis/config/spring-config.xml");
	
	public SegmentationService segmentationService = (SegmentationService) context.getBean("segmentationService");
	
	@Test
	public void testName() throws Exception {
		//获取数据库中文本记录
		List<ComplaintText> list = segmentationService.getTextRecords();
		
		for(int k = 0; k < list.size(); k++){
			System.out.println(list.get(k).getComplaintContent());
		}
		
		String[] keyWords = {"蔡进坤","福建","工程"};
		
		//匹配关键词，获取匹配结果
		List<String> matchResults = segmentationService.getMatchingTexts(list, keyWords);
		
		for(int i = 0; i < matchResults.size(); i++){
			System.out.println(matchResults.get(i));
		}
	}
	
}
