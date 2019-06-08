package com.coll.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ForumDAO;
import com.coll.model.Forum;

public class ForumDAOTest {

	static ForumDAO forumDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	@Ignore
	@Test
	public void addforumtest() {
		Forum forum=new Forum();
		forum.setForumName("new forum");
		forum.setForumContent("used for implementation");
		forum.setCreateDate(new java.util.Date());
		forum.setUsername("naveen");
		forum.setStatus("NA");
		assertTrue("problem in adding forum",forumDAO.addForum(forum));
	}
	@Ignore
	@Test
	public void getforumtest() {
		assertNotNull("problem in getting forum",forumDAO.getForum(502));
	}
	@Ignore
	@Test
	public void updateforumtest() {
		Forum forum=forumDAO.getForum(501);
		forum.setForumContent("content is written here");
		assertTrue("problem in updating forum",forumDAO.updateForum(forum));
	}
	@Ignore
	@Test
	public void deleteforumtest() {
		Forum forum=forumDAO.getForum(502);
		assertTrue("problem in deleting forum",forumDAO.deleteForum(forum));
	}
	@Ignore
	@Test
	public void listblogtest() {
		List<Forum> listForums=forumDAO.getForums();
		for(Forum forum:listForums) {
			System.out.println("id:"+forum.getForumId());
		}
	}
	@Ignore
	@Test
	public void approveforumtest() {
		Forum forum=forumDAO.getForum(502);
		assertTrue("problem in approving",forumDAO.approveForum(forum));
	}
	@Ignore
	@Test
	public void rejectforumtest() {
		Forum forum=forumDAO.getForum(502);
		assertTrue("problem in rejecting",forumDAO.rejectForum(forum));
	}
}






