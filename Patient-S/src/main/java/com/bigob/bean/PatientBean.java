package com.bigob.bean;

import com.google.gson.Gson;

public class PatientBean {

	private Integer pId;
	private String fName;
	private String lName;
	private String mobile;
	private String email;
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
