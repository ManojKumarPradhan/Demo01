package com.bigob.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.Gson;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	public Integer getpId() {
		return pId;
	}
	public Patient setpId(Integer pId) {
		this.pId = pId;
		return this;
	}
	public String getfName() {
		return fName;
	}
	public Patient setfName(String fName) {
		this.fName = fName;
		return this;
	}
	public String getlName() {
		return lName;
	}
	public Patient setlName(String lName) {
		this.lName = lName;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public Patient setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Patient setEmail(String email) {
		this.email = email;
		return this;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Patient setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
