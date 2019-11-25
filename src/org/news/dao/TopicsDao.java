package org.news.dao;

import java.util.List;
import org.news.entity.Topic;

public interface TopicsDao {

   List<Topic> getAllTopics();

   int updateTopic(Topic var1);

   Topic findTopicByName(String var1);

   int addTopic(Topic topic);

   int deleteTopic(int var1);
   
   Topic getById(int id);
}
