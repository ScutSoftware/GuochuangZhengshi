package com.lis.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lis.dao.TFIDFDao;
import com.lis.model.TFIDF;
import com.lis.service.ClusterService;
import com.lis.service.ParticipleAndFilterService;

public class ClusterServiceTest {
	
	public ApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/lis/config/spring-config.xml");
	public ClusterService clusterService = (ClusterService) context.getBean("clusterService");
	public ParticipleAndFilterService participleAndFilterService = (ParticipleAndFilterService) context.getBean("participleAndFilterService");
	@Test
	public void testName() throws Exception {
		List<String> ss = participleAndFilterService.getNouns();
		List<String> m1 = clusterService.megaOutPut(ss);
	     for(int i = 0;i<m1.size();i++)
	    	 System.out.print(m1.get(i));

	     double[] xs = clusterService.outPoint();
	     for(int i = 0;i<xs.length;i++)
	    	 System.out.print(xs[i]);
	}
}
