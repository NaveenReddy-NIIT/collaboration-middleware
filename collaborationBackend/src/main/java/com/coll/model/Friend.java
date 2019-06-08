package com.coll.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Friend {
	
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="friendid")
@SequenceGenerator(name="friendid",allocationSize=1,sequenceName="friendid_seq")
private int friendId;
private String username;
private String friendusername;
private String friendFirstName;
private String friendLastName;
private String status;

public int getFriendId() {
	return friendId;
}
public void setFriendId(int friendId) {
	this.friendId = friendId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getFriendusername() {
	return friendusername;
}
public void setFriendusername(String friendusername) {
	this.friendusername = friendusername;
}
public String getFriendFirstName() {
	return friendFirstName;
}
public void setFriendFirstName(String friendFirstName) {
	this.friendFirstName = friendFirstName;
}
public String getFriendLastName() {
	return friendLastName;
}
public void setFriendLastName(String friendLastName) {
	this.friendLastName = friendLastName;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
