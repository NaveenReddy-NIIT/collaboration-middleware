package com.coll.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

@RestController
public class BlogRestController {
	
	@Autowired
	BlogDAO blogDAO;
	
	@GetMapping("/getBlogs")
	public ResponseEntity<List<Blog>> getBlogs() 
	{
		List<Blog> listBlogs=blogDAO.getBlogs();
		if(listBlogs.size()>0)
		{
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getBlog/{blogId}")
	public ResponseEntity<Blog> getBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	@PostMapping("/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setBlogName("angularjs");
		blog.setBlogContent("good for beginners");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setUsername("naveen");
		blog.setLikes(0);
		blog.setDislikes(0);
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("Blog added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in adding blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/updateBlog")
	public ResponseEntity<String> updateBlog(@RequestBody Blog blog)
	{
		if(blogDAO.updateBlog(blog)) 
		{
			return new ResponseEntity<String>("Blog updated",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error in  updating blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		if(blogDAO.deleteBlog(blog)) 
		{
			return new ResponseEntity<String>("Blog deleted",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error in  deleting blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		if(blogDAO.approveBlog(blog)) 
		{
			return new ResponseEntity<String>("Blog approved",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error in  approving blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		if(blogDAO.rejectBlog(blog)) 
		{
			return new ResponseEntity<String>("Blog rejected successfully",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error in rejecting blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/incrementLikes/{blogId}")
	public ResponseEntity<String> incrementLikes(@PathVariable("blogId") int blogId)
	{
		if(blogDAO.incrementLikes(blogId)) 
		{
			return new ResponseEntity<String>("incremented Likes",HttpStatus.OK);
		}
		else 
	    {
			return new ResponseEntity<String>("Error in incrementing Likes",HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@GetMapping("/incrementDislikes/{blogId}")
	public ResponseEntity<String> incrementLDislikes(@PathVariable("blogId") int blogId)
	
	{
		if(blogDAO.incrementDislikes(blogId)) 
		{
			return new ResponseEntity<String>("incremented Dislikes",HttpStatus.OK);
		}
		else 
	    {
			return new ResponseEntity<String>("Error in incrementing Dislikes",HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
}	
	
	
