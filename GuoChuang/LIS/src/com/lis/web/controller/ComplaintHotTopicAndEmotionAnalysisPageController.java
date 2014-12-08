package com.lis.web.controller;

import java.security.Timestamp;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lis.model.ComplaintText;
import com.lis.model.IntermediateWord;
import com.lis.service.ClusterService;
import com.lis.service.ComplaintHotTopicAndEmotionAnalysisPageService;
import com.lis.service.ParticipleAndFilterService;
import com.lis.service.SegmentationService;
import com.lis.util.HQLConditionQuery;
import com.lis.util.HQLOrderBy;

@Controller
@RequestMapping("complainthottopic/")
public class ComplaintHotTopicAndEmotionAnalysisPageController {

	@Autowired
	private ComplaintHotTopicAndEmotionAnalysisPageService complaintHotTopicAndEmotionAnalysisPageService;
	@Autowired
	private ClusterService clusterService ;
	@Autowired
	private ParticipleAndFilterService participleAndFilterService ;
	@Autowired
	private SegmentationService segmentationService ;
	

	

	//动态实现查询关键词对应文本
	@RequestMapping(value = "getMatchingComplaintTexts", method = RequestMethod.POST)
	public @ResponseBody Object getMatchingComplaintTexts(
			@RequestParam(value="keyword")String keyword,HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			/*
            System.out.print(keyword);
            List<ComplaintText> complaintTextList = complaintHotTopicAndEmotionAnalysisPageService.getAllTextRecords();
            */
			
			Date systemDate =  new Date() ;
			Calendar testCalendar = Calendar.getInstance() ;	
			testCalendar.set(2014, systemDate.getMonth(), systemDate.getDate(), systemDate.getHours(), systemDate.getMinutes(), systemDate.getSeconds());
			testCalendar.add(Calendar.HOUR, -1);
			SimpleDateFormat changeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
	        //startDate.set
			String endTime = changeFormat.format(systemDate) ;	
			String startTime = changeFormat.format(testCalendar.getTime()) ;
			System.out.println(endTime);
			System.out.println(startTime);
			endTime = endTime.replace(":", "\\:");
			startTime = startTime.replace(":", "\\:");//加转义符防止冒号被HQL识别
	        List<ComplaintText> queryComplaintText= segmentationService.getTextRecordsInsertTime(startTime, endTime) ;
	        
            String emotion = complaintHotTopicAndEmotionAnalysisPageService.getEmotionLevel(keyword);
            System.out.print(emotion);
            String [] keywordArray = new String [1] ;
            keywordArray[0] = keyword ;
		    List<String> matchingText = segmentationService.getMatchingTexts(queryComplaintText, keywordArray);
		    map.put("matchingText", matchingText);
		    map.put("emotionLevel", emotion);
		    map.put("success", true);
		
			return map;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("success", false);
			return map;

		}
		
	}
	
	//主页面
	@RequestMapping(value = "getTextRecords", method = RequestMethod.GET)
	public  String getTextRecords(ModelMap map) throws Exception{
      /*
		List<ComplaintText> complaintTextList = complaintHotTopicAndEmotionAnalysisPageService.getAllTextRecords();
		List<String> Noun = participleAndFilterService.getNounsFromCompContent(complaintTextList);
		List<String> keywordList = clusterService.megaOutPut(Noun);
		List<Time> timeSettingAllList =  complaintHotTopicAndEmotionAnalysisPageService.getTimeSetting() ;
		List<Integer> timeSettingList = new ArrayList<>() ;
		for(int i = 0 ; i < timeSettingAllList.size() ;i++){
			timeSettingList.add(timeSettingAllList.get(i).getHours());
		}
		for(int i = 0 ;i< keywordList.size() ;i++){
			System.out.print(keywordList.get(i)) ;
		}
		map.put("complaintTextList", complaintTextList) ;
		map.put("keywordList", keywordList) ;
		*/
		List<Time> timeSettingAllList =  complaintHotTopicAndEmotionAnalysisPageService.getTimeSetting() ;
		List<Integer> timeSettingList = new ArrayList<>() ;
		for(int i = 0 ; i < timeSettingAllList.size() ;i++){
			timeSettingList.add(timeSettingAllList.get(i).getHours());
		}
		map.put("timeSettingList", timeSettingList) ;
		map.put("success", true);
		return "complainthottopic/complainthotWord";
	}
	
	//获取热点文本投诉记录
	@RequestMapping(value = "getTextRecordsAjax", method = RequestMethod.GET)
	public  @ResponseBody Object getTextRecordsAjax(@RequestParam(value="timeSetting")String timeSetting,HttpServletRequest req
			  ) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		Date systemDate =  new Date() ;
		Calendar testCalendar = Calendar.getInstance() ;	
		testCalendar.set(2014, systemDate.getMonth(), systemDate.getDate(), systemDate.getHours(), systemDate.getMinutes(), systemDate.getSeconds());
		testCalendar.add(Calendar.HOUR, -1);
		SimpleDateFormat changeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        //startDate.set
		String endTime = changeFormat.format(systemDate) ;	
		String startTime = changeFormat.format(testCalendar.getTime()) ;
		System.out.println(endTime);
		System.out.println(startTime);
		endTime = endTime.replace(":", "\\:");
		startTime = startTime.replace(":", "\\:");//加转义符防止冒号被HQL识别
        List<ComplaintText> queryComplaintText= segmentationService.getTextRecordsInsertTime(startTime, endTime) ;
        List<String> noun = participleAndFilterService.getNounAdjVerbs(queryComplaintText) ;
        List<String> keywordList = clusterService.megaOutPut(noun) ;
        System.out.print(queryComplaintText.get(0));
        /*
        List<String> queryTexts = new ArrayList<>() ; 
        for(int i = 0 ; i < queryComplaintText.size() ; i++){
           queryTexts.add(queryComplaintText.get(i).getComplaintContent()) ;
        }
        */
		map.put("keywordList", keywordList ) ;
		map.put("success", true) ;
		return map ;
	}
	
	//实现跨页面跳转到文本查询页面
	@RequestMapping(value = "getServiceRequestType", method = RequestMethod.GET)
	public  String getServiceRequestType(ModelMap map){
		
		//List<IntermediateWord> wordList = keywordCorrectAndFeedbackPageService.list();
		//map.addAttribute("wordList", wordList);
		
		return "segmentation/query";
	}
	
	//跳转页面到查询设置
	@RequestMapping(value = "querySetting", method = RequestMethod.GET)
	public  String getQuerySetting(ModelMap map){
		

		
		return "querysetting/querySetting";
	}
	
	//用于重复跳转自己的页面
	@RequestMapping(value = "getTextRecordsChange", method = RequestMethod.POST)
	public  String getTextRecordsChange(ModelMap map) throws Exception{

		List<ComplaintText> complaintTextList = complaintHotTopicAndEmotionAnalysisPageService.getAllTextRecords();
		List<String> Noun = participleAndFilterService.getNounsFromCompContent(complaintTextList);
		List<String> keywordList = clusterService.megaOutPut(Noun);
		for(int i = 0 ;i< keywordList.size() ;i++){
			System.out.print(keywordList.get(i));
		}
		map.put("complaintTextList", complaintTextList);
		map.put("keywordList", keywordList);
		map.put("success", true);
		return "/complainthotWord";
	}
}
