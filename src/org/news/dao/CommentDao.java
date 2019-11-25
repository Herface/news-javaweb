package org.news.dao;

import java.util.List;

import org.news.entity.Comment;

public interface CommentDao {
	List<Comment> queryAll(int cnid);
	void add(Comment comment);
	
}
