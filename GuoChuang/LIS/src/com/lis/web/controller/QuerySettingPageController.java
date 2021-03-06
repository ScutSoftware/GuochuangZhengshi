package com.lis.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lis.model.BussinessKeyword;
import com.lis.model.EmotionKeyword;
import com.lis.model.ServiceRequestType;
import com.lis.service.QuerySettingPageService;

@Controller
@RequestMapping("querysetting/")

public class QuerySettingPageController {

	@Autowired
	private QuerySettingPageService querySettingPageService;
	
	@RequestMapping(value = "getServiceRequestType", method = RequestMethod.GET)
	public  String getServiceRequestType(ModelMap map){
		String ss = getKeyWordFromDB(map);
		getLevelTreeFromDB(map);
		getEmotionWordFromDB(map);
		return ss;
	}
	
	@RequestMapping(value = "postToQuerySetting", method = RequestMethod.POST)
	public String postToQuerySetting(ModelMap map,
			@RequestParam(value="routePath")String routePath,
			@RequestParam(value="timeToUpdat")String timeToUpdat,
			@RequestParam(value="keywordNumber")String keywordNumber,
			@RequestParam(value="summaryTime1")String summaryTime1,
			@RequestParam(value="summaryTime2")String summaryTime2,
			@RequestParam(value="summaryTime3")String summaryTime3){
		try{
			if(!routePath.trim().equals("")){
				boolean s = querySettingPageService.setTextStorePath(routePath);
				if(!s){
					throw new Exception("routePath insert error");
				}
			}
			if(!timeToUpdat.trim().equals("")){
				boolean s = querySettingPageService.setUpdateInterval(timeToUpdat);
				if(!s){
					throw new Exception("timeToUpdat insert error");
				}
			}
			if(!keywordNumber.trim().equals("")){
				
				int showNum = Integer.parseInt(keywordNumber);
				boolean s = querySettingPageService.setKeyWordShowNumber(showNum);
				if(!s){
					throw new Exception("showNUm insert error");
				}
			}
			if(!summaryTime1.trim().equals("")){
				boolean s = querySettingPageService.setTrendCountTime1(summaryTime1);
				if(!s){
					throw new Exception("summaryTime1 insert error");
				}
			}
			if(!summaryTime2.trim().equals("")){
				boolean s = querySettingPageService.setTrendCountTime2(summaryTime2);
				if(!s){
					throw new Exception("summaryTime2 insert error");
				}
			}
			if(!summaryTime3.trim().equals("")){
				boolean s = querySettingPageService.setTrendCountTime3(summaryTime3);
				if(!s){
					throw new Exception("summaryTime3 insert error");
				}
			}
			getServiceRequestType(map);
			map.put("success", true);
			return "querysetting/querySetting";
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			return "querysetting/querySetting";
			
		}
	}
	//从数据库中获取主题词
	public String  getKeyWordFromDB(ModelMap map){
		try{
		//获取文本记录热门主题词
		List<BussinessKeyword> keywordList = querySettingPageService.getBusinessKeywords();
		
		if(keywordList == null){
			map.put("success", false);
			return "querysetting/querySetting";
		}
		else{
			map.put("keywordList", keywordList);
			map.put("success", true);
			return "querysetting/querySetting";
		}
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			return "querysetting/querySetting";
		}
	}
//新增主题词
	@RequestMapping(value = "keyWordAdd", method = RequestMethod.POST)
	public String keyWordAdd(ModelMap map,
			@RequestParam(value="newKeyWord")String newKeyWord){
		try{
			if(!newKeyWord.trim().equals("")){
				BussinessKeyword entity = new BussinessKeyword();
				entity.setBussinessKeyword(newKeyWord);
				boolean s = querySettingPageService.saveKeyWord(entity);
				if(!s)
					throw new Exception("newKeyWord insert error");
				String ss = getServiceRequestType(map);
				map.put("success", true);
				return "querysetting/querySetting";
			}
			
			map.put("success", false);
			return "querysetting/querySetting";
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			return "querysetting/querySetting";
		}
	}
	//删除主题词
	@RequestMapping(value = "keyWordDel", method = RequestMethod.POST)
	public String keyWordDel(ModelMap map,
			@RequestParam(value="keyword")String keyword){
		
		try{
			if(!keyword.trim().equals("")){
				BussinessKeyword entity = new BussinessKeyword();
				entity.setBussinessKeyword(keyword);
				boolean s = querySettingPageService.delKeyWord(entity);
				if(!s)
					throw new Exception("keyWord del error");
				String ss = getServiceRequestType(map);
				map.put("success", true);
				return "querysetting/querySetting";
			}
			map.put("success", false);
			return "querysetting/querySetting";
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			return "querysetting/querySetting";
		}
	}
	//显示业务结构树层级
	public String getLevelTreeFromDB(ModelMap map){
		try{
			List<ServiceRequestType> list = querySettingPageService.getServiceRequestType();
			if(list!=null){
				List<ServiceRequestType> treeLevel1List1 = new ArrayList();
				List<ServiceRequestType> treeLevel1List2 = new ArrayList();
				List<ServiceRequestType> treeLevel1List3 = new ArrayList();
				List<ServiceRequestType> treeLevel1List4 = new ArrayList();
				List<ServiceRequestType> treeLevel1List5 = new ArrayList();
				for(int i = 0;i<list.size();i++){
					if(list.get(i).getAllCodeID().trim().length()==2)
						treeLevel1List1.add(list.get(i));
					else if(list.get(i).getAllCodeID().trim().length()==4)
						treeLevel1List2.add(list.get(i));
					else if(list.get(i).getAllCodeID().trim().length()==6)
						treeLevel1List3.add(list.get(i));
					else if(list.get(i).getAllCodeID().trim().length()==8)
						treeLevel1List4.add(list.get(i));
					else if(list.get(i).getAllCodeID().trim().length()==10)
						treeLevel1List5.add(list.get(i));
				}
				map.put("treeLevel1List1", treeLevel1List1);
				map.put("treeLevel1List2", treeLevel1List2);
				map.put("treeLevel1List3", treeLevel1List3);
				map.put("treeLevel1List4", treeLevel1List4);
				map.put("treeLevel1List5", treeLevel1List5);
				map.put("success", true);
				return "querysetting/querySetting";
			}
			else{
				map.put("success", false);
				return "querysetting/querySetting";
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			return "querysetting/querySetting";
		}
	}
    //显示情感词汇
	public String getEmotionWordFromDB(ModelMap map){
		try{
			List<EmotionKeyword> list = querySettingPageService.getEmotionWord();
			if(list!=null){
				List<EmotionKeyword> qiangLie = new ArrayList();
				List<EmotionKeyword> zhongDeng = new ArrayList();
				List<EmotionKeyword> qingWei = new ArrayList();
				for(int i = 0;i<list.size();i++){
					if(list.get(i).getEmotionDegree().trim().equals("强烈"))
						qiangLie.add(list.get(i));
					else if(list.get(i).getEmotionDegree().trim().equals("中等"))
						zhongDeng.add(list.get(i));
					else if(list.get(i).getEmotionDegree().trim().equals("轻微"))
						qingWei.add(list.get(i));
				}
				map.put("qiangLie", qiangLie);
				map.put("zhongDeng", zhongDeng);
				map.put("qingWei", qingWei);
				map.put("success", true);
				return "querysetting/querySetting";
			}else{
				map.put("success", false);
				return "querysetting/querySetting";
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			return "querysetting/querySetting";
		}
	}

	//删除强烈词语
	@RequestMapping(value = "qianglieDel", method = RequestMethod.POST)
	public String qianglieDel(ModelMap map,
			@RequestParam(value="qiangLie")String keyword){
		
		try{
			if(!keyword.trim().equals("")){
				EmotionKeyword entity = new EmotionKeyword();
				entity.setEmotionKeyword(keyword);
				boolean s = querySettingPageService.delEmotionWord(entity);
				if(!s)
					throw new Exception("EmotionWord del error");
				String ss = getServiceRequestType(map);
				map.put("success", true);
				return "querysetting/querySetting";
			}
			map.put("success", false);
			return "querysetting/querySetting";
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			return "querysetting/querySetting";
		}
	}
	//删除中等词语
	@RequestMapping(value = "zhongdengDel", method = RequestMethod.POST)
	public String zhongdengDel(ModelMap map,
			@RequestParam(value="zhongDeng")String keyword){
		
		try{
			if(!keyword.trim().equals("")){
				EmotionKeyword entity = new EmotionKeyword();
				entity.setEmotionKeyword(keyword);
				boolean s = querySettingPageService.delEmotionWord(entity);
				if(!s)
					throw new Exception("EmotionWord del error");
				String ss = getServiceRequestType(map);
				map.put("success", true);
				return "querysetting/querySetting";
			}
			map.put("success", false);
			return "querysetting/querySetting";
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			return "querysetting/querySetting";
		}
	}
	//删除轻微词语
	@RequestMapping(value = "qingweiDel", method = RequestMethod.POST)
	public String qingweiDel(ModelMap map,
			@RequestParam(value="qingWei")String keyword){
		
		try{
			if(!keyword.trim().equals("")){
				EmotionKeyword entity = new EmotionKeyword();
				entity.setEmotionKeyword(keyword);
				boolean s = querySettingPageService.delEmotionWord(entity);
				if(!s)
					throw new Exception("EmotionWord del error");
				String ss = getServiceRequestType(map);
				map.put("success", true);
				return "querysetting/querySetting";
			}
			map.put("success", false);
			return "querysetting/querySetting";
			
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			return "querysetting/querySetting";
		}
	}

	//新增强烈词
		@RequestMapping(value = "qingLieAdd", method = RequestMethod.POST)
		public String qingLieAdd(ModelMap map,
				@RequestParam(value="newEmotionWord")String newKeyWord){
			try{
				if(!newKeyWord.trim().equals("")){
					EmotionKeyword entity = new EmotionKeyword();
					entity.setEmotionKeyword(newKeyWord);
					entity.setEmotionDegree("强烈");
					boolean s = querySettingPageService.saveEmotionWord(entity);
					if(!s)
						throw new Exception("newEmotionWord insert error");
					String ss = getServiceRequestType(map);
					map.put("success", true);
					return "querysetting/querySetting";
				}
				
				map.put("success", false);
				return "querysetting/querySetting";
				
			}catch(Exception e){
				e.printStackTrace();
				map.put("success", false);
				return "querysetting/querySetting";
			}
		}
		//新增中等词
		@RequestMapping(value = "zhongDengAdd", method = RequestMethod.POST)
		public String zhongDengAdd(ModelMap map,
				@RequestParam(value="newEmotionWord")String newKeyWord){
			try{
				if(!newKeyWord.trim().equals("")){
					EmotionKeyword entity = new EmotionKeyword();
					entity.setEmotionKeyword(newKeyWord);
					entity.setEmotionDegree("中等");
					boolean s = querySettingPageService.saveEmotionWord(entity);
					if(!s)
						throw new Exception("newEmotionWord insert error");
					String ss = getServiceRequestType(map);
					map.put("success", true);
					return "querysetting/querySetting";
				}
				
				map.put("success", false);
				return "querysetting/querySetting";
				
			}catch(Exception e){
				e.printStackTrace();
				map.put("success", false);
				return "querysetting/querySetting";
			}
		}
		//新增轻微词
		@RequestMapping(value = "qingWeiAdd", method = RequestMethod.POST)
		public String qingWeiAdd(ModelMap map,
				@RequestParam(value="newEmotionWord")String newKeyWord){
			try{
				if(!newKeyWord.trim().equals("")){
					EmotionKeyword entity = new EmotionKeyword();
					entity.setEmotionKeyword(newKeyWord);
					entity.setEmotionDegree("轻微");
					boolean s = querySettingPageService.saveEmotionWord(entity);
					if(!s)
						throw new Exception("newEmotionWord insert error");
					String ss = getServiceRequestType(map);
					map.put("success", true);
					return "querysetting/querySetting";
				}
				
				map.put("success", false);
				return "querysetting/querySetting";
				
			}catch(Exception e){
				e.printStackTrace();
				map.put("success", false);
				return "querysetting/querySetting";
			}
		}
}


