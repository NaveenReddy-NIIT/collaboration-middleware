package com.coll.daotest;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.UserDetailDAO;
import com.coll.model.UserDetail;

public class UserDetailDAOTest {

static UserDetailDAO userdetailDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}
	
	
	@Test
	public void addusertest() {
		UserDetail userDetail=new UserDetail();
		userDetail.setUsername("srinivas");
		userDetail.setFirstname("srinivas");
		userDetail.setLastname("reddy");
		userDetail.setPassword("srinivas");
		userDetail.setEmailId("sri@gmail.com");
		assertTrue("problem in adding user",userdetailDAO.addUser(userDetail));
	}
	@Ignore
	@Test
	public void getusertest() {
		assertNotNull("problem in getting user",userdetailDAO.getUser("srinivas"));
	}
	@Ignore
	@Test
	public void updateusertest() {
		UserDetail userDetail=userdetailDAO.getUser("srinivas");
		userDetail.setLastname("srini");
		assertTrue("problem in updating user",userdetailDAO.updateUser(userDetail));
	}
	@Ignore
	@Test
	public void listusertest() {
		List<UserDetail> listUsers=userdetailDAO.getUsers();
		for(UserDetail userDetail:listUsers) {
			System.out.println("username:"+userDetail.getUsername());
		}
	}
	
	@Test
	public void checkusertest() {
		UserDetail userDetail=userdetailDAO.getUser("srinivas");
		assertNotNull("problem in checking user",userdetailDAO.checkUser(userDetail));
	}
}