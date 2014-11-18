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
@Table(name = "t_intermediate_words")
public class IntermediateWord implements Serializable {

	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	@Column(name = "PK_Intermediate_Words_ID", nullable = false, unique = true)
	private int intermediateWordIDPK;
	@Column(name = "Intermedate_Word", nullable = false, length = 20)
	private String word;
	@Column(name = "Score", nullable = false, length = 20)
	private double score;

	public int getIntermediateWordIDPK() {
		return intermediateWordIDPK;
	}

	public void setIntermediateWordIDPK(int intermediateWordIDPK) {
		this.intermediateWordIDPK = intermediateWordIDPK;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "IntermediateWord [word=" + word + ", score=" + score + "]";
	}

	

}
