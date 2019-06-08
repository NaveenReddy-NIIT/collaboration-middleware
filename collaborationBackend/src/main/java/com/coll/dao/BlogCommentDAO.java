package com.coll.dao;

import java.util.List;

import com.coll.model.BlogComment;

public interface BlogCommentDAO {

	public boolean addBlogComment(BlogComment blogcomment);
	public boolean updateBlogComment(BlogComment blogcomment);
	public boolean deleteBlogComment(BlogComment blogcomment);
	public BlogComment getBlogComment(int commentId);
	public List<BlogComment> getBlogComments();
	
}
