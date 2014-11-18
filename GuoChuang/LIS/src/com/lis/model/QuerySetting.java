package com.lis.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@SuppressWarnings("serial")
@Entity
@Table(name="t_query_setting")
public class QuerySetting implements Serializable{
	@Id
	@GenericGenerator(name="generator", strategy="identity")
	@GeneratedValue(generator="generator")
	@Column(name="PK_Query_Setting_ID", nullable=false, unique=true)
	private int querySettingIDPK ;
	@Column(name="Update_Interval", nullable=false )
	private Time updateInterval;
	@Column(name="Text_Score_Path", nullable=false,unique=true,length = 30)
	private String textScorePath;
	@Column(name="Keyword_Show_Number", nullable=false )
	private int keywordShowNumber;
	@Column(name="Trend_Count_Time_1", nullable=false )
	private Time trendCountTime1;
	@Column(name="Trend_Count_Time_2", nullable=false )
	private Time trendCountTime2;
	@Column(name="Trend_Count_Time_3", nullable=false )
	private Time trendCountTime3;
	public String getTextScorePath() {
		return textScorePath;
	}
	public void setTextScorePath(String textScorePath) {
		this.textScorePath = textScorePath;
	}
	public int getQuerySettingIDPK() {
		return querySettingIDPK;
	}
	public void setQuerySettingIDPK(int querySettingIDPK) {
		this.querySettingIDPK = querySettingIDPK;
	}
	public Time getUpdateInterval() {
		return updateInterval;
	}
	public void setUpdateInterval(Time updateInterval) {
		this.updateInterval = updateInterval;
	}
	public int getKeywordShowNumber() {
		return keywordShowNumber;
	}
	public void setKeywordShowNumber(int keywordShowNumber) {
		this.keywordShowNumber = keywordShowNumber;
	}
	public Time getTrendCountTime1() {
		return trendCountTime1;
	}
	public void setTrendCountTime1(Time trendCountTime1) {
		this.trendCountTime1 = trendCountTime1;
	}
	public Time getTrendCountTime2() {
		return trendCountTime2;
	}
	public void setTrendCountTime2(Time trendCountTime2) {
		this.trendCountTime2 = trendCountTime2;
	}
	public Time getTrendCountTime3() {
		return trendCountTime3;
	}
	public void setTrendCountTime3(Time trendCountTime3) {
		this.trendCountTime3 = trendCountTime3;
	}
	
	
}
