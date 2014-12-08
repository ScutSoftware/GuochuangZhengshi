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
@Table(name="t_method2")
public class Method2 implements Serializable{

	@Id
	@GenericGenerator(name="generator", strategy="identity")
	@GeneratedValue(generator="generator")
	@Column(name="PK_Method2_ID", nullable=false, unique=true)
	private int method2IDPK ;
	@Column(name="Name", nullable=false, length=20)
	private String name;
	@Column(name="Score", nullable=true )
	private int score;
	public int getMethod2IDPK() {
		return method2IDPK;
	}
	public void setMethod2IDPK(int method2idpk) {
		method2IDPK = method2idpk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
