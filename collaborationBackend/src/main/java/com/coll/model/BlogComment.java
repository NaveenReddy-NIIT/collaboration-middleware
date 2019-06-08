package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class BlogComment {

@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogcomid")
@SequenceGenerator(name="blogcomid",allocationSize=1,sequenceName="blogcommentId_seq")

private int commentId;
private int blogId;
private String blogComment;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yyyy")
private Date commentDate;
private String username;

public int getCommentId() {
	return commentId;
}
public void setCommentId(int commentId) {
	this.commentId = commentId;
}
public int getBlogId() {
	return blogId;
}
public void setBlogId(int blogId) {
	this.blogId = blogId;
}
public String getBlogComment() {
	return blogComment;
}
public void setBlogComment(String blogComment) {
	this.blogComment = blogComment;
}
public Date getCommentDate() {
	return commentDate;
}
public void setCommentDate(Date commentDate) {
	this.commentDate = commentDate;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
}