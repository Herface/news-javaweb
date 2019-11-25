
package org.news.service;

import org.news.dao.CommentDao;
import org.news.dao.impl.CommentDaoImpl;
import org.news.entity.Comment;

public class CommentService {
	private CommentDao commentDao = new CommentDaoImpl();
	public void add(Comment comment) {
		commentDao.add(comment);
		
	}
	
}
