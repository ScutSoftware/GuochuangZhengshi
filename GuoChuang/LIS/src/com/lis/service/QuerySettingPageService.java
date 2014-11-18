package com.lis.service;


import java.util.List;

import com.lis.model.BussinessKeyword;
import com.lis.model.EmotionKeyword;
import com.lis.model.ServiceRequestType;

public interface QuerySettingPageService {
	//设置文档存储路径
	public boolean setTextStorePath(String path);
	//设置文本记录更新时间间隔
	public boolean setUpdateInterval(String interval);
	//设置第一个统计时常
	public boolean setTrendCountTime1(String time1);
	//设置第二个统计时常
	public boolean setTrendCountTime2(String time1);
	//设置第三个统计时常
	public boolean setTrendCountTime3(String time1);
	//设置显示主题词的个数
	public boolean setKeyWordShowNumber(int s);
	//从数据库中选出关键词
	public List<BussinessKeyword> getBusinessKeywords();
	//向数据库中插入关键词
	public boolean saveKeyWord(BussinessKeyword entity);
	//删除关键词
	public boolean delKeyWord(BussinessKeyword entity);
	//获取业务结构树
	public List<ServiceRequestType> getServiceRequestType();
	//获取情感关键词
	public List<EmotionKeyword> getEmotionWord();
	//删除情感词汇
	public boolean delEmotionWord(EmotionKeyword entity);
	//新增情感词汇
	public boolean saveEmotionWord(EmotionKeyword entity);
}
