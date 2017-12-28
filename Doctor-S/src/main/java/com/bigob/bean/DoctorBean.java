package com.bigob.bean;

import com.google.gson.Gson;

import io.swagger.annotations.ApiModelProperty;

public class DoctorBean {

	@ApiModelProperty(value="Doctor ID", required=true)
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
	private String joiningDate;
	@ApiModelProperty("AT What time Doctor enter to Hospital")
	private String entryTime;
	@ApiModelProperty("AT what time Doctor will leave")
	private String exitTime;
	public Integer getdId() {
		return dId;
	}
	public DoctorBean setdId(Integer dId) {
		this.dId = dId;
		return this;
	}
	public String getfName() {
		return fName;
	}
	public DoctorBean setfName(String fName) {
		this.fName = fName;
		return this;
	}
	public String getLname() {
		return lname;
	}
	public DoctorBean setLname(String lname) {
		this.lname = lname;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public DoctorBean setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getMonile() {
		return mobile;
	}
	public DoctorBean setMonile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public DoctorBean setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
		return this;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public DoctorBean setEntryTime(String entryTime) {
		this.entryTime = entryTime;
		return this;
	}
	public String getExitTime() {
		return exitTime;
	}
	public DoctorBean setExitTime(String exitTime) {
		this.exitTime = exitTime;
		return this;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
