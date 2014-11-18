package com.lis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lis.model.AlgorithmWeight;
import com.lis.service.PrioritySortService;
import com.lis.service.SegmentationService;

public class PrioritySortTest {

	public ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/lis/config/spring-config.xml");
	
	public PrioritySortService prioritySortService = (PrioritySortService) context.getBean("prioritySortService");
	
	@Test
	public void testName() throws Exception {
		
//		String[] keyword = {"你好", "他好", "大家好", "星期一"};
//		String[] method1 = {"今天", "明天", "你好", "昨天"};
//		String[] method2 = {"苹果", "他好", "番茄", "大家好"};
//		prioritySortService.keywordSort(keyword, method1, method2);
		
	}
	
	
}
