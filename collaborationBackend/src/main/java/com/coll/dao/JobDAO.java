package com.coll.dao;

import java.util.List;

import com.coll.model.Job;

public interface JobDAO {

	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public Job getJob(int jobId);
	public List<Job> getJobs();
	
}
