package com.lis.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="t_emotion_keyword")
public class EmotionKeyword implements Serializable{
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	@Column(name = "PK_Emotion_Keyword_ID", nullable = false, unique = true)
	private Integer emotionKeywordIDPK;
	@Column(name = "Emotion_Keyword", nullable = false ,length = 5)
	private String  emotionKeyword;
	@Column(name = "Emotion_Degree", nullable = false,length = 5)
    private String emotionDegree;
	public Integer getEmotionKeywordIDPK() {
		return emotionKeywordIDPK;
	}
	public void setEmotionKeywordIDPK(Integer emotionKeywordIDPK) {
		this.emotionKeywordIDPK = emotionKeywordIDPK;
	}
	public String getEmotionKeyword() {
		return emotionKeyword;
	}
	public void setEmotionKeyword(String emotionKeyword) {
		this.emotionKeyword = emotionKeyword;
	}
	public String getEmotionDegree() {
		return emotionDegree;
	}
	public void setEmotionDegree(String emotionDegree) {
		this.emotionDegree = emotionDegree;
	}
	

}
