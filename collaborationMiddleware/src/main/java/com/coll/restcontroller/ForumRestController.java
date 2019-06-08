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

import com.coll.dao.ForumDAO;
import com.coll.model.Forum;

@RestController
public class ForumRestController {

	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping("/getForums") 
	public ResponseEntity<List<Forum>> getForums() 
	{
		List<Forum> listForums=forumDAO.getForums();
		if(listForums.size()>0) {
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getForum/{forumId}")
	public ResponseEntity<Forum> getForum(@PathVariable("forumId") int forumId) 
	{
		Forum forum=forumDAO.getForum(forumId);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	@PostMapping("/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		forum.setForumName("forum2");
		forum.setForumContent("used for implementation");
		forum.setCreateDate(new java.util.Date());
		forum.setUsername("naveen");
		forum.setStatus("NA");
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in adding forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/updateForum")
	public ResponseEntity<String> updateForum(@RequestBody Forum forum)
	{
		if(forumDAO.updateForum(forum)) 
		{
			return new ResponseEntity<String>("Forum updated",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error in updating forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/deleteForum/{forumId}")
	public ResponseEntity<String> deleteForum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		if(forumDAO.deleteForum(forum)) 
		{
			return new ResponseEntity<String>("Forum deleted",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error in deleting forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/approveForum/{forumId}")
	public ResponseEntity<String> approveForum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		if(forumDAO.approveForum(forum)) 
		{
			return new ResponseEntity<String>("Forum approved",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error in approving forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("/rejectForum/{forumId}")
	public ResponseEntity<String> rejectForum(@PathVariable("forumId") int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		if(forumDAO.rejectForum(forum)) 
		{
			return new ResponseEntity<String>("Forum rejected",HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<String>("Error in rejecting forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}