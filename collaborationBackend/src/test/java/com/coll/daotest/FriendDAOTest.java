package com.coll.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.FriendDAO;
import com.coll.model.Friend;
import com.coll.model.UserDetail;

public class FriendDAOTest {

static FriendDAO friendDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	@Ignore
	@Test
	public void sendfriendrequesttest() {
		Friend friend=new Friend();
		friend.setFriendFirstName("rajesh");
		friend.setFriendLastName("reddy");
		friend.setFriendusername("rajesh");
		friend.setUsername("naveen");
		friend.setStatus("NA");
		assertTrue("problem in adding friend",friendDAO.sendFriendRequest(friend));
	}
	@Ignore
	@Test
	public void getfriendtest() {
		assertNotNull("problem in getting user",friendDAO.getFriend(501));
	}
	@Ignore
	@Test
	public void acceptfriendrequesttest() {
		Friend friend=friendDAO.getFriend(501);
		assertTrue("problem in adding friend",friendDAO.acceptFriendRequest(friend));
	}
    @Ignore
	@Test
	public void deletefriendrequesttest() {
		Friend friend=friendDAO.getFriend(502);
		assertTrue("problem in adding friend",friendDAO.deleteFriendRequest(friend));
	}
    @Ignore
	@Test
	public void showfriendlisttest() {
		List<Friend> listFriends=friendDAO.showFriendList("naveen");
		for(Friend friend:listFriends) {
			System.out.println("username:"+friend.getFriendusername());
		}
	}
	@Ignore
	@Test
	public void showpendingfriendrequesttest() {
		List<Friend> listFriends=friendDAO.showPendingFriendRequest("naveen");
		for(Friend friend:listFriends) {
			System.out.println("username:"+friend.getFriendusername());
		}
	}
	@Ignore
	@Test
	public void showsuggestedfriendstest() {
		List<UserDetail> listUsers=friendDAO.showSuggestedFriends("naveen");
		for(UserDetail userDetail:listUsers) {
			System.out.println("username:"+userDetail.getUsername());
		}
	}
}