package com.coll.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Forum;
import com.coll.model.ForumComment;
import com.coll.model.Friend;
import com.coll.model.Job;
import com.coll.dao.BlogCommentDAO;
import com.coll.dao.BlogCommentDAOImpl;
import com.coll.dao.BlogDAO;
import com.coll.dao.BlogDAOImpl;
import com.coll.dao.ForumCommentDAO;
import com.coll.dao.ForumCommentDAOImpl;
import com.coll.dao.ForumDAO;
import com.coll.dao.ForumDAOImpl;
import com.coll.dao.FriendDAO;
import com.coll.dao.FriendDAOImpl;
import com.coll.dao.JobDAO;
import com.coll.dao.JobDAOImpl;
import com.coll.dao.UserDetailDAO;
import com.coll.dao.UserDetailDAOImpl;
import com.coll.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.coll.*")
public class DBConfig {
	

	@Bean(name="datasource")
	public DataSource getoracleDataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:nav");
		datasource.setUsername("naveen");
		datasource.setPassword("naveen");
		System.out.println("..Datasource object created....");
		return datasource;
	}


	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateprop=new Properties();
		
		
		hibernateprop.put("hibernate.hbm2ddl.auto","update");
		hibernateprop.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getoracleDataSource());

		factory.addProperties(hibernateprop);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Blog.class);
		factory.addAnnotatedClass(BlogComment.class);
		factory.addAnnotatedClass(Forum.class);
		factory.addAnnotatedClass(ForumComment.class);
		factory.addAnnotatedClass(Friend.class);
		factory.addAnnotatedClass(Job.class);
	    System.out.println("...SessionFactory Object created...");

		return factory.buildSessionFactory();
		
	}
	
	@Bean(name="TransactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("..TransactionManager Object created...");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean(name="userdetailDAO") 
	public UserDetailDAO getUserDetailDAO() {
		return new UserDetailDAOImpl();
	}
	
	@Bean(name="blogDAO") 
	public BlogDAO getBlogDAO() {
		return new BlogDAOImpl();
	}
	
	@Bean(name="blogcommentDAO") 
	public BlogCommentDAO getBlogCommentDAO() {
		return new BlogCommentDAOImpl();
	}
	
	@Bean(name="forumDAO") 
	public ForumDAO getForumDAO() {
		return new ForumDAOImpl();
	}
	@Bean(name="forumcommentDAO") 
	public ForumCommentDAO getForumCommentDAO() {
		return new ForumCommentDAOImpl();
	}
	
	@Bean(name="friendDAO") 
	public FriendDAO getFriendDAO() {
		return new FriendDAOImpl();
	}
	
	@Bean(name="jobDAO") 
	public JobDAO getJobDAO() {
		return new JobDAOImpl();
	}
}
