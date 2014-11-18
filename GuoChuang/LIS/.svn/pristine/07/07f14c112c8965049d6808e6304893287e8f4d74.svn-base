package com.lis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.service.impl.BaseServiceImpl;
import com.lis.model.ServiceRequestType;
import com.lis.service.ServiceRequestTypeService;
import com.lis.util.ConditionQuery;
import com.lis.util.HQLConditionQuery;
import com.lis.util.HQLOrderBy;
import com.lis.util.OrderBy;
import com.lis.dao.BaseDao;
import com.lis.dao.ServiceRequestTypeDao;


@Service("serviceRequestTypeService")
@Transactional
public class ServiceRequestTypeServiceImpl extends BaseServiceImpl<ServiceRequestType,Integer> implements ServiceRequestTypeService{

	//@Autowired
	private ServiceRequestTypeDao serviceTypeDao;
	@Autowired
	public void setBaseDao(BaseDao<ServiceRequestType,Integer>serviceTypeDao){
		this.baseDao=serviceTypeDao;
		this.serviceTypeDao=(ServiceRequestTypeDao)serviceTypeDao;
}
	@Override
	public List<ServiceRequestType> getServiceRequestTypeByParentID(
			String parentID) {
		try {
			HQLConditionQuery query = new HQLConditionQuery();
			HQLOrderBy orderBy = new HQLOrderBy();
			List<HQLConditionQuery> queryList = new ArrayList<HQLConditionQuery>();
			List<HQLOrderBy> orderByList = new ArrayList<HQLOrderBy>();
			query.add("parentID =:ID", "ID", parentID);
			queryList.add(query);
			orderByList.add(orderBy);
			List<ServiceRequestType> list = serviceTypeDao.list(queryList,orderByList);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Object getInitServiceRequestType() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<ServiceRequestType> levelOne = null;
		List<ServiceRequestType> levelTwo = null;
		List<ServiceRequestType> levelThree = null;
		List<ServiceRequestType> levelFour = null;
		List<ServiceRequestType> levelFive = null;
		
		try {
			levelOne = getServiceRequestTypeByParentID("");
			if(levelOne != null){
				levelTwo = getServiceRequestTypeByParentID(levelOne.get(0).getAllCodeID());			
			}
			
			if(levelTwo != null){				
				levelThree = getServiceRequestTypeByParentID(levelTwo.get(0).getAllCodeID());
			}
			
			if(levelThree != null){
				levelFour = getServiceRequestTypeByParentID(levelThree.get(0).getAllCodeID());				
			}
			
			if(levelFour != null){
				levelFive = getServiceRequestTypeByParentID(levelFour.get(0).getAllCodeID());				
			}
			map.put("levelOne", levelOne);
			map.put("levelTwo", levelTwo);
			map.put("levelThree", levelThree);
			map.put("levelFour", levelFour);
			map.put("levelFive", levelFive);
			return map;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
}
