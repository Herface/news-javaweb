package org.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.news.dao.BaseDao;
import org.news.dao.TopicsDao;
import org.news.entity.Topic;

public class TopicsDaoImpl extends BaseDao implements TopicsDao {

   public List<Topic> getAllTopics() {
      ArrayList list = new ArrayList();
      ResultSet rs = null;
      String sql = "select * from t_topic";

      try {
         rs = this.executeQuery(sql, new Object[0]);
         Topic e = null;

         while(rs.next()) {
            e = new Topic();
            e.setTid(rs.getInt("tid"));
            e.setTname(rs.getString("tname"));
            list.add(e);
         }
      } catch (SQLException var8) {
         var8.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, rs);
      }

      return list;
   }

   public int deleteTopic(int tid) {
      String sql = "DELETE FROM T_TOPIC WHERE tid = ?";
      int result = 0;

      try {
         result = this.executeUpdate(sql, tid);
      } catch (Exception var8) {
         var8.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, (ResultSet)null);
      }

      return result;
   }

   public int updateTopic(Topic topic) {
      String sql = "UPDATE T_TOPIC SET tname = ? WHERE tid = ?";
      int result = 0;

      try {
         result = this.executeUpdate(sql, new Object[]{topic.getTname(), Integer.valueOf(topic.getTid())});
      } catch (Exception var8) {
         var8.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, (ResultSet)null);
      }

      return result;
   }

   public Topic findTopicByName(String name) {
      String sql = "select * from t_topic where tname=?";
      ResultSet rs = null;
      Topic topic = null;

      try {
         rs = this.executeQuery(sql, new Object[]{name});
         if(rs.next()) {
            topic = new Topic();
            topic.setTid(rs.getInt("tid"));
            topic.setTname(rs.getString("tname"));
         }
      } catch (SQLException var9) {
         var9.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, rs);
      }

      return topic;
   }

   public int addTopic(Topic topic) {
      String sql = "insert into t_topic(TNAME) values(?)";
      int result = 0;

      try {
         result = this.executeUpdate(sql, topic.getTname());
      } catch (Exception var8) {
         var8.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, (ResultSet)null);
      }

      return result;
   }

@Override
public Topic getById(int id) {
	// TODO Auto-generated method stub
	String sql = "select * from t_topic where tid = ?";
	ResultSet rs = null;
    Topic e = null;
     try {
        rs = this.executeQuery(sql, id);
        while(rs.next()) {
           e = new Topic();
           e.setTid(rs.getInt("tid"));
           e.setTname(rs.getString("tname"));
        }
     } catch (SQLException var8) {
        var8.printStackTrace();
     } finally {
        this.closeAll(this.conn, (Statement)null, rs);
     }

	return e;
}
}
