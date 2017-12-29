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
public class Doctor {

	@ApiModelProperty(value="Doctor ID", required=true)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer dId;
	@ApiModelProperty("First Name Of the Doctor")
	private String fName;
	@ApiModelProperty("Last Name Of the Doctor")
	private String lname;
	@ApiModelProperty("Email ID of the Doctor")
	private String email;
	@ApiModelProperty("Mobile Number of the Doctor")
	private String mobile;
	@ApiModelProperty("Joining Date Of the Doctor")
	@Temporal(TemporalType.TIMESTAMP)
	private Date joiningDate;
	@ApiModelProperty("AT What time Doctor enter to Hospital")
	private String entryTime;
	@ApiModelProperty("AT what time Doctor will leave")
	private String exitTime;
	public Integer getdId() {
		return dId;
	}
	public Doctor setdId(Integer dId) {
		this.dId = dId;
		return this;
	}
	public String getfName() {
		return fName;
	}
	public Doctor setfName(String fName) {
		this.fName = fName;
		return this;
	}
	public String getLname() {
		return lname;
	}
	public Doctor setLname(String lname) {
		this.lname = lname;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Doctor setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getMobile() {
		return mobile;
	}
	public Doctor setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public Doctor setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
		return this;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public Doctor setEntryTime(String entryTime) {
		this.entryTime = entryTime;
		return this;
	}
	public String getExitTime() {
		return exitTime;
	}
	public Doctor setExitTime(String exitTime) {
		this.exitTime = exitTime;
		return this;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
