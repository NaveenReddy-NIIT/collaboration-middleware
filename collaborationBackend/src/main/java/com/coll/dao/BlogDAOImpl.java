package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired 
	SessionFactory sessionFactory;

	@Override
	public boolean addBlog(Blog blog) {

		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {

		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e) {
		return false;
		}
	}

	@Override
	public Blog getBlog(int blogId) {
		Session session=sessionFactory.openSession();
		Blog blog=session.get(Blog.class,blogId);
		session.close();
		return blog;
	}

	@Override
	public List<Blog> getBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> listBlogs=query.list();
		return listBlogs;
	}

	@Override
	public boolean incrementLikes(int blogId) {
		
		try {
			Blog blog=getBlog(blogId);
			blog.setLikes(blog.getLikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean incrementDislikes(int blogId) {
		
		try {
			Blog blog=getBlog(blogId);
			blog.setDislikes(blog.getDislikes()+1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean approveBlog(Blog blog) {
	
		try {
		    blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean rejectBlog(Blog blog) {
		
		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}	