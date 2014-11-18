package com.lis.service;

import java.util.List;

import com.lis.model.ComplaintText;

/**
 * <p>类名称:ParticipleAndFilterService</p>
 * <p>类描述:对文本进行分词及过滤</p>
 * <p>单位:华南理工大学软件学院</p>
 * @创建人 yixiu
 * @创建时间 2014年10月29日 下午7:43:15
 * @创建人联系方式：williamhao@foxmail.com
 * @version v1.0
 */

public interface ParticipleAndFilterService {
	//从数据库中找出所有文本记录进行分词，返回筛选出的所有名词
	public List<String> getNouns();
	
	//接收投诉文本并分词，返回所有名词
	public List<String> getNounsFromCompContent(List<ComplaintText> list);

}
