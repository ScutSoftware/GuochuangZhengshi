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
@Table(name="t_service_request_type")
public class ServiceRequestType implements Serializable{
	
	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	@Column(name = "PK_Service_Request_Type_ID", nullable = false, unique = true)
	private Integer serviceRequestTypeIDPK;
	@Column(name = "All_Code_ID", nullable = false,length = 10)
	private String allCodeID;
	@Column(name = "Parent_ID", nullable = true , length = 10)
	private String parentID;
	@Column(name = "Service_Request_Name", nullable = false,length = 15)
	private String serviceRequestName;
	public Integer getServiceRequestTypeIDPK() {
		return serviceRequestTypeIDPK;
	}
	public void setServiceRequestTypeIDPK(Integer serviceRequestTypeIDPK) {
		this.serviceRequestTypeIDPK = serviceRequestTypeIDPK;
	}
	public String getAllCodeID() {
		return allCodeID;
	}
	public void setAllCodeID(String allCodeID) {
		this.allCodeID = allCodeID;
	}
	public String getParentID() {
		return parentID;
	}
	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	public String getServiceRequestName() {
		return serviceRequestName;
	}
	public void setServiceRequestName(String serviceRequestName) {
		this.serviceRequestName = serviceRequestName;
	}
	@Override
	public String toString() {
		return "ServiceRequestType [serviceRequestTypeIDPK="
				+ serviceRequestTypeIDPK + ", allCodeID=" + allCodeID
				+ ", parentID=" + parentID + ", serviceRequestName="
				+ serviceRequestName + "]";
	}

	

}
