package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Forum {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumid")
@SequenceGenerator(name="forumid",allocationSize=1,sequenceName="forumId_seq")

private int forumId;
private String forumName;
private String forumContent;
private String username;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
private Date createDate;
private String status;

public int getForumId() {
	return forumId;
}
public void setForumId(int forumId) {
	this.forumId = forumId;
}
public String getForumName() {
	return forumName;
}
public void setForumName(String forumName) {
	this.forumName = forumName;
}
public String getForumContent() {
	return forumContent;
}
public void setForumContent(String forumContent) {
	this.forumContent = forumContent;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
