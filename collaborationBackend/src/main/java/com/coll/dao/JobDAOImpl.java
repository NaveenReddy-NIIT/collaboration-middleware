package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addJob(Job job) {
		
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
			}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteJob(Job job) {

		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
			}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Job getJob(int jobId) {
		Session session=sessionFactory.openSession();
		Job job=session.get(Job.class,jobId);
		session.close();
		return job;
	}

	@Override
	public List<Job> getJobs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> listJobs=query.list();
		return listJobs;
	}

}