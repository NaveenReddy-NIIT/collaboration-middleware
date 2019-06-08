package com.coll.dao;

import java.util.List;

import com.coll.model.UserDetail;

public interface UserDetailDAO 
{
	public boolean addUser(UserDetail userDetail);
	public UserDetail getUser(String username);
	public boolean updateUser(UserDetail userDetail);
	public List<UserDetail> getUsers();
	public UserDetail checkUser(UserDetail userDetail);
}
