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
@Table(name="t_algorithm_weight")
public class AlgorithmWeight implements Serializable{

	@Id
	@GenericGenerator(name="generator", strategy="identity")
	@GeneratedValue(generator="generator")
	@Column(name="PK_Algorithm_Weight_ID", nullable=false, unique=true)
	private int algorithmWeightIDPK ;
	@Column(name="Algorithm_Name", nullable=false, length=10)
	private String algorithmName;
	@Column(name="Weight", nullable=false, length=20)
	private double weight;
	public int getAlgorithmWeightIDPK() {
		return algorithmWeightIDPK;
	}
	public void setAlgorithmWeightIDPK(int algorithmWeightIDPK) {
		this.algorithmWeightIDPK = algorithmWeightIDPK;
	}
	public String getAlgorithmName() {
		return algorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
