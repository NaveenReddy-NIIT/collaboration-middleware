package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Job {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobid")
@SequenceGenerator(name="jobid",allocationSize=1,sequenceName="jobid_seq")
private int jobId;
private String jobDesignation;
private String companyName;
private int CTC;
private String jobLocation;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
private Date lastDate;
private String skills;

public int getJobId() {
	return jobId;
}
public void setJobId(int jobId) {
	this.jobId = jobId;
}
public String getJobDesignation() {
	return jobDesignation;
}
public void setJobDesignation(String jobDesignation) {
	this.jobDesignation = jobDesignation;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String companyName) {
	this.companyName = companyName;
}
public int getCTC() {
	return CTC;
}
public void setCTC(int cTC) {
	CTC = cTC;
}
public String getJobLocation() {
	return jobLocation;
}
public void setJobLocation(String jobLocation) {
	this.jobLocation = jobLocation;
}
public Date getLastDate() {
	return lastDate;
}
public void setLastDate(Date lastDate) {
	this.lastDate = lastDate;
}
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}

}