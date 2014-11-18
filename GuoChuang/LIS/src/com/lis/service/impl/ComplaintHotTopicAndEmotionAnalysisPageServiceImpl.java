package com.lis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.dao.ComplaintTextDao;
import com.lis.dao.EmotionKeywordDao;
import com.lis.model.ComplaintText;
import com.lis.model.EmotionKeyword;
import com.lis.service.ComplaintHotTopicAndEmotionAnalysisPageService;

@Service("complaintHotTopicAndEmotionAnalysisPageService")
@Transactional
public class ComplaintHotTopicAndEmotionAnalysisPageServiceImpl implements ComplaintHotTopicAndEmotionAnalysisPageService{

	
	private ComplaintTextDao complaintTextDao;
	private EmotionKeywordDao emotionKeywordDao;
	
	@Autowired
	public void setComplaintTextDao(ComplaintTextDao complaintTextDao) {
		this.complaintTextDao = complaintTextDao;
	}
	
	@Autowired
	public void setEmotionKeywordDao(EmotionKeywordDao emotionKeywordDao) {
		this.emotionKeywordDao = emotionKeywordDao;
	}


	@Override
	public List<ComplaintText> getAllTextRecords() {
		// TODO Auto-generated method stub
		try {
			List<ComplaintText> list = complaintTextDao.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String getEmotionLevel(String keyword){
		List<EmotionKeyword> list = new ArrayList<EmotionKeyword>();
        list = emotionKeywordDao.list();
        String emotion ;
        for(int i = 0 ;i < list.size() ; i++){
        	if(keyword.equals(list.get(i).getEmotionKeyword())){
        		emotion=list.get(i).getEmotionDegree();
        		return emotion ;
        	}
        }
		return "test";
		
	}
}
