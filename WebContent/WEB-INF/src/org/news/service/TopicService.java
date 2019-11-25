package org.news.service;

import java.util.List;

import org.news.dao.TopicsDao;
import org.news.dao.impl.TopicsDaoImpl;
import org.news.entity.Topic;

public class TopicService {
	
	private TopicsDao topicsDao=new TopicsDaoImpl();
	/**
	 * 获取所有话题
	 * 
	 * @return
	 */
	public List<Topic> getTopicList() {
		List<Topic> list = topicsDao.getAllTopics();
		
		return list;	
	}
	
	public boolean addTopic(Topic topic) {
		
		Topic t =topicsDao.findTopicByName(topic.getTname());
		if(t==null) {
			topicsDao.addTopic(topic);
			return true;
		}
		return false;
	}
	
	public boolean deleteById(int id) {
		
		return topicsDao.deleteTopic(id) > 1;
	}
	
	public Topic getById(int id) {
		return topicsDao.getById(id);
		
	}
	
	public boolean update(Topic t) {
		boolean flag = false;
		if(topicsDao.findTopicByName(t.getTname())==null) {
			topicsDao.updateTopic(t);
			flag = true;
		}
		return flag;
		
		
		
	}
}
