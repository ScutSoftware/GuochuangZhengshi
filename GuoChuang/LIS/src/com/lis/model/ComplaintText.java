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
@Table(name="t_complaint_text")
public class ComplaintText implements Serializable {

	@Id
	@GenericGenerator(name = "generator", strategy = "identity")
	@GeneratedValue(generator = "generator")
	@Column(name = "PK_Complaint_Text_ID", nullable = false, unique = true)
	private Integer complaintTextIDPK;
	@Column(name = "Serial_Number", nullable = false ,length = 15)
	private String  serialNumber;
	@Column(name = "Process_Time", nullable = false)
    private Date processTime;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_Bussiness_City")
	private BussinessCity bussinessCityFK;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_Service_Request_Type")
	private ServiceRequestType serviceRequestTypeFK;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_Problem_Type")
	private ProblemType problemTypeFK;
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_Problem_Detail")
	private ProblemDetail problemDetailFK;

	@Column(name = "Complaint_Content", nullable = false,length = 150)
	private String complaintContent;
	@Column(name = "Complaint_Template", nullable = false,length = 150)
	private String complaintTemplate;
	public Integer getComplaintTextIDPK() {
		return complaintTextIDPK;
	}
	public void setComplaintTextIDPK(Integer complaintTextIDPK) {
		this.complaintTextIDPK = complaintTextIDPK;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Date getProcessTime() {
		return processTime;
	}
	public void setProcessTime(Date processTime) {
		this.processTime = processTime;
	}
	public BussinessCity getBussinessCityFK() {
		return bussinessCityFK;
	}
	public void setBussinessCityFK(BussinessCity bussinessCityFK) {
		this.bussinessCityFK = bussinessCityFK;
	}
	public ServiceRequestType getServiceRequestTypeFK() {
		return serviceRequestTypeFK;
	}
	public void setServiceRequestTypeFK(ServiceRequestType serviceRequestTypeFK) {
		this.serviceRequestTypeFK = serviceRequestTypeFK;
	}
	public ProblemType getProblemTypeFK() {
		return problemTypeFK;
	}
	public void setProblemTypeFK(ProblemType problemTypeFK) {
		this.problemTypeFK = problemTypeFK;
	}
	public ProblemDetail getProblemDetailFK() {
		return problemDetailFK;
	}
	public void setProblemDetailFK(ProblemDetail problemDetailFK) {
		this.problemDetailFK = problemDetailFK;
	}
	public String getComplaintContent() {
		return complaintContent;
	}
	public void setComplaintContent(String complaintContent) {
		this.complaintContent = complaintContent;
	}
	public String getComplaintTemplate() {
		return complaintTemplate;
	}
	public void setComplaintTemplate(String complaintTemplate) {
		this.complaintTemplate = complaintTemplate;
	}
	
	
	
}
