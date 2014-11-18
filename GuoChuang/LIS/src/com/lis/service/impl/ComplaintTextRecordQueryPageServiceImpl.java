package com.lis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.service.impl.BaseServiceImpl;
import com.lis.model.ComplaintText;
import com.lis.service.ComplaintTextRecordQueryPageService;
import com.lis.dao.BaseDao;
import com.lis.dao.ComplaintTextDao;


@Service
@Transactional
public class ComplaintTextRecordQueryPageServiceImpl extends BaseServiceImpl<ComplaintText,Integer> implements ComplaintTextRecordQueryPageService{
	@Autowired
	private ComplaintTextDao complainTextDao;
	@Autowired
	public void setBaseDao(BaseDao<ComplaintText,Integer>complainTextDao){
		this.baseDao=complainTextDao;
		this.complainTextDao=(ComplaintTextDao)complainTextDao;
	}

	
}
