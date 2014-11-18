package com.lis.service.impl;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.dao.BussinessKeywordDao;
import com.lis.dao.EmotionKeywordDao;
import com.lis.dao.QuerySettingDao;
import com.lis.dao.ServiceRequestTypeDao;
import com.lis.model.BussinessKeyword;
import com.lis.model.EmotionKeyword;
import com.lis.model.ServiceRequestType;
import com.lis.service.QuerySettingPageService;
@Service("querySettingPageService")
@Transactional
public class QuerySettingPageServiceImpl implements QuerySettingPageService{
	private QuerySettingDao querySettingDao;
	private BussinessKeywordDao bussinessKeywordDao;
	private ServiceRequestTypeDao serviceRequestTypeDao;
	private EmotionKeywordDao emotionKeywordDao;
	@Autowired
	public void setQuerySettingDao(QuerySettingDao querySettingDao) {
		this.querySettingDao = querySettingDao;
	}
	@Autowired
	public void setBussinessKeywordDao(BussinessKeywordDao bussinessKeywordDao) {
		this.bussinessKeywordDao = bussinessKeywordDao;
	}
	@Autowired
	public void setServiceRequestTypeDao(ServiceRequestTypeDao serviceRequestTypeDao) {
		this.serviceRequestTypeDao = serviceRequestTypeDao;
	}
	@Autowired
	public void setEmotionKeywordDao(EmotionKeywordDao emotionKeywordDao) {
		this.emotionKeywordDao = emotionKeywordDao;
	}
	
	public boolean setTextStorePath(String path){
		try{
		querySettingDao.list().get(0).setTextScorePath(path);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean setUpdateInterval(String interval){
		try{
		Time bt = Time.valueOf(interval);
		querySettingDao.list().get(0).setUpdateInterval(bt);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean setTrendCountTime1(String time1){
		try{
		Time bt = Time.valueOf(time1);
		querySettingDao.list().get(0).setTrendCountTime1(bt);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean setTrendCountTime2(String time1){
		try{
		Time bt = Time.valueOf(time1);
		querySettingDao.list().get(0).setTrendCountTime2(bt);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean setTrendCountTime3(String time1){
		try{
		Time bt = Time.valueOf(time1);
		querySettingDao.list().get(0).setTrendCountTime3(bt);
		return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean setKeyWordShowNumber(int s){
		try{
		querySettingDao.list().get(0).setKeywordShowNumber(s);
		return true;
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public List<BussinessKeyword> getBusinessKeywords() {
		// TODO Auto-generated method stub
		try {
			return bussinessKeywordDao.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public List<ServiceRequestType> getServiceRequestType(){
		try {
			return serviceRequestTypeDao.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public boolean saveKeyWord(BussinessKeyword entity){
		
		try{
	
			bussinessKeywordDao.save(entity);

			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean delKeyWord(BussinessKeyword entity){
		try{
			List<BussinessKeyword> list = bussinessKeywordDao.list();
			List poit = new ArrayList();
			for(int i = 0;i<list.size();i++){
				if(list.get(i).getBussinessKeyword().trim().equals(entity.getBussinessKeyword().trim()))
					poit.add(i);
			}
			for(int i = poit.size();i>0;i--){
				bussinessKeywordDao.delete(list.get(Integer.parseInt(poit.get(i-1).toString())));
			}
			
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public List<EmotionKeyword> getEmotionWord(){
		try {
			return emotionKeywordDao.list();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public boolean delEmotionWord(EmotionKeyword entity){
		try{
			List<EmotionKeyword> list = emotionKeywordDao.list();
			List poit = new ArrayList();
			for(int i = 0;i<list.size();i++){
				if(list.get(i).getEmotionKeyword().trim().equals(entity.getEmotionKeyword().trim()))
					poit.add(i);
			}
			for(int i = poit.size();i>0;i--){
				emotionKeywordDao.delete(list.get(Integer.parseInt(poit.get(i-1).toString())));
			}
			
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean saveEmotionWord(EmotionKeyword entity){
		
		try{
	
			emotionKeywordDao.save(entity);

			return true;
		}catch(Exception e){
			return false;
		}
	}
}
