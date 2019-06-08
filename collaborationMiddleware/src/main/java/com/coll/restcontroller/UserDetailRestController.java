package com.coll.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.UserDetailDAO;
import com.coll.model.UserDetail;

@RestController
public class UserDetailRestController {
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<UserDetail>> getUsers() 
	{
		List<UserDetail> listUsers=userDetailDAO.getUsers();
		if(listUsers.size()>0) {
			return new ResponseEntity<List<UserDetail>>(listUsers,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<UserDetail>>(listUsers,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getUser/{username}")
	public ResponseEntity<UserDetail> getUser(@PathVariable("username") String username)
	{
		UserDetail userDetail=userDetailDAO.getUser(username);
		return new ResponseEntity<UserDetail>(userDetail,HttpStatus.OK);
	}
	
	@PostMapping("/addUser") 
	public ResponseEntity<String> addUser(@RequestBody UserDetail userDetail)
	{
		userDetail.setRole("ROLE_USER");
		userDetail.setStatus("A");
		userDetail.setIsOnline("Y");
		if(userDetailDAO.addUser(userDetail)) {
			return new ResponseEntity<String>("User added",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("User not added",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/checkUser")
	public ResponseEntity<UserDetail> checkUser(@RequestBody UserDetail userDetail,HttpSession session)
	{
		UserDetail userDetail1=userDetailDAO.checkUser(userDetail);
		if(userDetail1!=null)
		{
			session.setAttribute("UserDetail",userDetail1);
			return new ResponseEntity<UserDetail>(userDetail1,HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<UserDetail>(userDetail1,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody UserDetail userDetail)
	{
		if(userDetailDAO.updateUser(userDetail)) {
			return new ResponseEntity<String>("User updated",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("User not updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
