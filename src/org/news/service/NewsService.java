package org.news.service;

import java.util.List;

import org.news.dao.CommentDao;
import org.news.dao.NewsDao;
import org.news.dao.impl.CommentDaoImpl;
import org.news.dao.impl.NewsDaoImpl;
import org.news.entity.Comment;
import org.news.entity.News;

public class NewsService {
	private NewsDao newsDao=new NewsDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl();
	public List<News> getNewsList(){
		List<News> list=newsDao.getAllnews();
		return list;
	}
	
	public boolean addNews(News n) {
		boolean flag = true;
		try {
		newsDao.add(n);
		}catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	public boolean deleteById(int id) {
		boolean flag = true;
		try {
		newsDao.deleteById(id);
		}catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public News getById(int id) {
		
		News n =  newsDao.getById(id);
		List<Comment> comments = commentDao.queryAll(n.getNid());
		n.setComments(comments);
		
		return n;
		
	}
	
	public boolean update(News n) {
		try {
		newsDao.update(n);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}
