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
@Table(name="t_bussiness_keyword")
public class BussinessKeyword implements Serializable {

	@Id
	@GenericGenerator(name="generator", strategy="identity")
	@GeneratedValue(generator="generator")
	@Column(name="PK_Bussiness_Keyword_ID", nullable=false, unique=true)
	private int bussinessKeywordIDPK ;
	@Column(name="Bussiness_Keyword", nullable=false, length=5)
	private String bussinessKeyword;
	public int getBussinessKeywordIDPK() {
		return bussinessKeywordIDPK;
	}
	public void setBussinessKeywordIDPK(int bussinessKeywordIDPK) {
		this.bussinessKeywordIDPK = bussinessKeywordIDPK;
	}
	public String getBussinessKeyword() {
		return bussinessKeyword;
	}
	public void setBussinessKeyword(String bussinessKeyword) {
		this.bussinessKeyword = bussinessKeyword;
	}
	
	

}
