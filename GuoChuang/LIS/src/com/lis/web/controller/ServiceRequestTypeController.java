package com.lis.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lis.model.ServiceRequestType;
import com.lis.service.ServiceRequestTypeService;

@Controller
@RequestMapping("serviceRequestType/")
public class ServiceRequestTypeController {

	@Autowired
	private ServiceRequestTypeService serviceRequestTypeService;

	public void setServiceRequestTypeService(
			ServiceRequestTypeService serviceRequestTypeService) {
		this.serviceRequestTypeService = serviceRequestTypeService;
	}
	
	@RequestMapping(value = "getServiceRequestType", method = RequestMethod.GET)
	public @ResponseBody Object getServiceRequestType(
			@RequestParam(value="parentID")String parentID,
			HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<ServiceRequestType> list = serviceRequestTypeService.getServiceRequestTypeByParentID(parentID);
			map.put("serviceRequestTypeList", list);
			map.put("success",true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("success", false);
		}
		return map;
	}
	
	@RequestMapping( value = "getInitServiceRequestType", method = RequestMethod.GET)
	public @ResponseBody Object getInitServiceRequestType(HttpServletRequest req){
		System.out.println("----------------getInitServiceRequestType-------------");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Object obj = serviceRequestTypeService.getInitServiceRequestType();
			if(obj == null){
				map.put("success", false);
				return map;
			} else{
				map = (Map<String, Object>)obj;
				map.put("success",true);
				return map;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("success", false);
			return map;
		}
	}
}
