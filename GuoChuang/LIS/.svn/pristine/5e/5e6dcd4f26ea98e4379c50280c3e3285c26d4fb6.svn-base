package com.lis.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lis.model.ServiceRequestType;
import com.lis.service.SegmentationService;
import com.lis.service.ServiceRequestTypeService;

public class ServiceRequestTypeServiceTest {

	public ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/lis/config/spring-config.xml");
	
	public ServiceRequestTypeService serviceRequestTypeService = (ServiceRequestTypeService) context.getBean("serviceRequestTypeService");
	
	@Test
	public void testName() throws Exception {
		List<ServiceRequestType> list = serviceRequestTypeService.getServiceRequestTypeByParentID("");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
}
