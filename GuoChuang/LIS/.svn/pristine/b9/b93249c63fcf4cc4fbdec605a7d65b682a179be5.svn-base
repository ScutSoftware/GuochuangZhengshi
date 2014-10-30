package com.lis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name="t_tfidf")
public class TFIDF implements Serializable{
	
	@Id
	@GenericGenerator(name = "generator", strategy = "assigned")
	@GeneratedValue(generator = "generator")
	@Column(name = "PK_Word", nullable = false, unique = true ,length = 5)
	private String wordPK;
	@Column(name = "Score", nullable = false)
	private double score;
	public String getWordPK() {
		return wordPK;
	}
	public void setWordPK(String wordPK) {
		this.wordPK = wordPK;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	
}
