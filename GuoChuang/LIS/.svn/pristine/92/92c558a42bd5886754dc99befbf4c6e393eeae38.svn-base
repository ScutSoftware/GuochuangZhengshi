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
@Table(name="t_problem_detail")
public class ProblemDetail implements Serializable{

	@Id
	@GenericGenerator(name="generator", strategy="identity")
	@GeneratedValue(generator="generator")
	@Column(name="PK_Problem_Detail", nullable=false, unique=true)
	private int problemDetailPK ;
	@Column(name="Problem_Detail_ID", nullable=false, length=15)
	private String problemDetailID;
	@Column(name="Problem_Detail_Name", nullable=false, length=10)
	private String problemDetailName;
	public int getProblemDetailPK() {
		return problemDetailPK;
	}
	public void setProblemDetailPK(int problemDetailPK) {
		this.problemDetailPK = problemDetailPK;
	}
	public String getProblemDetailID() {
		return problemDetailID;
	}
	public void setProblemDetailID(String problemDetailID) {
		this.problemDetailID = problemDetailID;
	}
	public String getProblemDetailName() {
		return problemDetailName;
	}
	public void setProblemDetailName(String problemDetailName) {
		this.problemDetailName = problemDetailName;
	}
	
	
}
