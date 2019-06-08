package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.ForumComment;

@Repository("forumcommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addForumComment(ForumComment forumcomment) {
		
		try {
			sessionFactory.getCurrentSession().save(forumcomment);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean updateForumComment(ForumComment forumcomment) {
	
		try {
			sessionFactory.getCurrentSession().update(forumcomment);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean deleteForumComment(ForumComment forumcomment) {
		
		try {
			sessionFactory.getCurrentSession().delete(forumcomment);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public ForumComment getForumComment(int commentId) {
		Session session=sessionFactory.openSession();
		ForumComment forumcomment=session.get(ForumComment.class,commentId);
		session.close();
		return forumcomment;
	}

	@Override
	public List<ForumComment> getForumComments() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment");
		List<ForumComment> listComments=query.list();
		return listComments;
	}

}
