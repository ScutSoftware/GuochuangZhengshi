package com.lis.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lis.service.ImportFileToDatabaseService;
import com.lis.service.SegmentationService;

public class importFileToDatabaseTest {
public ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/lis/config/spring-config.xml");
	
	public ImportFileToDatabaseService segmentationService = (ImportFileToDatabaseService) context.getBean("importFileToDatabaseService");
	
	@Test
	public void testName() throws Exception {
//		segmentationService.importFile("E:\\project\\GuochuangFirst\\WENBEN_07_YUE_jiami.txt");
		segmentationService.scanDirectory();
	}
}
