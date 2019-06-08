package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.BlogComment;

@Repository("blogcommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlogComment(BlogComment blogcomment) {
		
		try {
			sessionFactory.getCurrentSession().save(blogcomment);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean updateBlogComment(BlogComment blogcomment) {
		
		try {
			sessionFactory.getCurrentSession().update(blogcomment);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean deleteBlogComment(BlogComment blogcomment) {
		
		try {
			sessionFactory.getCurrentSession().delete(blogcomment);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public BlogComment getBlogComment(int commentId) {
		Session session=sessionFactory.openSession();
		BlogComment blogcomment=session.get(BlogComment.class,commentId);
		session.close();
		return blogcomment;
	}

	@Override
	public List<BlogComment> getBlogComments() {
		Session session=sessionFactory.openSession();
	    Query query=session.createQuery("from BlogComment");
	    List<BlogComment> listComments=query.list();
	    return listComments;
	}
}
