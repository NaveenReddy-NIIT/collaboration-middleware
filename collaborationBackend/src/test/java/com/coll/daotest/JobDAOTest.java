package com.coll.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.JobDAO;
import com.coll.model.Job;

public class JobDAOTest {

	static JobDAO jobDAO;
	
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	@Ignore
	@Test
	public void addjobtest() {
		Job job=new Job();
		job.setJobDesignation("developer");
		job.setCompanyName("INFOSYS");
	    job.setCTC(400000);
	    job.setJobLocation("BANGOLORE");
	    job.setLastDate(new java.util.Date(2019,05,26));
	    job.setSkills("java");
	    assertTrue("problem in adding job",jobDAO.addJob(job));
	}
	@Ignore
	@Test
	public void getjobtest() {
		assertNotNull("problem in getting job",jobDAO.getJob(501));
	}
	@Test 
	public void getjobstest() {
		List<Job> listJobs=jobDAO.getJobs();
	    for(Job job:listJobs) {
	    	System.out.println("jobid:"+job.getJobId());
	    }
	}
	@Ignore
	@Test
	public void deletejobtest() {
		Job job=jobDAO.getJob(502);
		assertTrue("problem in adding job",jobDAO.deleteJob(job));
	}
}