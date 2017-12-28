package com.bigob.bean;

import com.google.gson.Gson;

import io.swagger.annotations.ApiModelProperty;

public class PatientBean {

	@ApiModelProperty(value="ID of a patient",required=true)
	private Integer pId;
	@ApiModelProperty(value="First Name Of the Patient")
	private String fName;
	@ApiModelProperty(value="Last Name Of the Patient")
	private String lName;
	@ApiModelProperty(value="Mobile Number Of the Patient")
	private String mobile;
	@ApiModelProperty(value="Email ID Of the Patient")
	private String email;
	@ApiModelProperty(value="Joining Date Of the Patient")
	private String createdDate;
	
	public Integer getpId() {
		return pId;
	}
	public PatientBean setpId(Integer pId) {
		this.pId = pId;
		return this;
	}
	public String getfName() {
		return fName;
	}
	public PatientBean setfName(String fName) {
		this.fName = fName;
		return this;
	}
	public String getlName() {
		return lName;
	}
	public PatientBean setlName(String lName) {
		this.lName = lName;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public PatientBean setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public PatientBean setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public PatientBean setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
