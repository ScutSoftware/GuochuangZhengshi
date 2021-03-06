package com.lis.service;

import java.util.List;

import com.lis.model.BussinessKeyword;
import com.lis.model.ComplaintText;


/**
 * <p>类名称:SegmentationService</p>
 * <p>类描述:根据投诉文本记录和主题词，进行匹配</p>
 * <p>单位:华南理工大学软件学院</p>
 * @创建人 caijinkun
 * @创建时间 2014年10月29日 下午7:43:15
 * @创建人联系方式：kejicjk@163.com
 * @version v1.0
 */
public interface SegmentationService {
	//字符串匹配函数，text是一条投诉文本记录，pattern是某个主题词，若匹配，则返回true,否则返回false
	public boolean isMatching(String Pattern ,String text);
	
	//获取匹配的投诉文本记录（List<ComplaintText> 投诉文本记录对象的list,String[] keyWords关键词数组）
	public List<String> getMatchingTexts(List<ComplaintText> list,String[] keyWords);
	
	//根据时间从数据库中获取所有的投诉文本记录
	public List<ComplaintText> getTextRecords(String startTime, String endTime);
	
	//从数据库汇总获取所有的投诉文本记录
	public List<ComplaintText> getTextRecords();
	
	
	//根据时间和服务类型从数据库汇总获取所有的投诉文本记录
	public List<ComplaintText> getTextRecords(String startTime, String endTime,String allCodeID);
	
	//获取业务主题词
	public List<BussinessKeyword> getBusinessKeywords();
	
	//获取符合插入时间的文本
	public List<ComplaintText> getTextRecordsInsertTime(String startTime, String endTime) ;
}
