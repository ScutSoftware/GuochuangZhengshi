package com.lis.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lis.model.ComplaintText;
import com.lis.service.ParticipleAndFilterService;
import com.lis.service.SegmentationService;

public class ParticipleAndFilterTest {
	
	public ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/lis/config/spring-config.xml");
	
	public ParticipleAndFilterService participleAndFilterService = (ParticipleAndFilterService) context.getBean("participleAndFilterService");
	
	@Test
	public void testName() throws Exception {
		List<String> ss = participleAndFilterService.getNouns();
		for(int i = 0;i<ss.size();i++)
			System.out.print(ss.get(i));
	}

}
