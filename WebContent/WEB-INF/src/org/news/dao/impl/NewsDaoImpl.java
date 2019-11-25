package org.news.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.news.dao.BaseDao;
import org.news.dao.NewsDao;
import org.news.entity.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {

   public List<News> getAllnews() {
      ArrayList<News> list = new ArrayList<News>();
      ResultSet rs = null;
//      String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`, `ncreateDate`, `nsummary`, `tname` FROM `NEWS`, `TOPIC` WHERE `NEWS`.`ntid` = `TOPIC`.`tid` ORDER BY `ncreateDate` DESC";
      String sql = "select * from t_news";
      try {
         rs = this.executeQuery(sql, new Object[0]);
         News e = null;

         while(rs.next()) {
            e = new News();
            e.setNid(rs.getInt("nid"));
            e.setNtid(rs.getInt("ntid"));
            e.setNtitle(rs.getString("ntitle"));
            e.setNauthor(rs.getString("nauthor"));
            e.setNcreatedate(rs.getTimestamp("ncreateDate"));
            e.setNsummary(rs.getString("nsummary"));
            e.setNtname(rs.getString("ntname"));
            list.add(e);
         }
      } catch (SQLException var8) {
         var8.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, rs);
      }

      return list;
   }

   public List<News> getAllnewsByTID(int tid) {
      ArrayList<News> list = new ArrayList<>();
      ResultSet rs = null;
//      String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`, `ncreateDate`, `nsummary`, `tname` FROM `t_new`, `t_topic` WHERE `t_new`.`ntid` = `t_topic`.`tid` AND `t_new`.`ntid` = ? ORDER BY `ncreateDate` DESC";
      String sql = "select * from t_news where ntid = ?";
      try {
         rs = this.executeQuery(sql, new Object[]{Integer.valueOf(tid)});
         News e = null;

         while(rs.next()) {
            e = new News();
            e.setNid(rs.getInt("nid"));
            e.setNtid(rs.getInt("ntid"));
            e.setNtitle(rs.getString("ntitle"));
            e.setNauthor(rs.getString("nauthor"));
            e.setNcreatedate(rs.getTimestamp("ncreateDate"));
            e.setNsummary(rs.getString("nsummary"));
            e.setNtname(rs.getString("tname"));
            list.add(e);
         }
      } catch (SQLException var9) {
         var9.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, rs);
      }

      return list;
   }

   public int getNewsCountByTID(int tid) {
      ResultSet rs = null;
      String sql = "SELECT COUNT(`ntid`) FROM `news` WHERE `ntid` = ?";
      int count = -1;

      try {
         rs = this.executeQuery(sql, new Object[]{Integer.valueOf(tid)});
         rs.next();
         count = rs.getInt(1);
      } catch (SQLException var9) {
         var9.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, rs);
      }

      return count;
   }

   public void add(News n) {
      String sql = "insert into t_news(ntid, ntitle, nauthor, nsummary, ncontent, ncreatedate)values(?, ?, ?, ?, ?,?)";
      Connection conn = this.getConnection();

      try {
         this.executeUpdate(sql, new Object[]{Integer.valueOf(n.getNtid()), n.getNtitle(), n.getNauthor(), n.getNsummary(), n.getNcontent(), new Date()});
      } catch (Exception var8) {
         var8.printStackTrace();
         throw new RuntimeException(var8);
      } finally {
         this.closeAll(conn, (Statement)null, (ResultSet)null);
      }

   }

@Override
public void deleteById(int id) {
	// TODO Auto-generated method stub
	String sql = "delete from t_news where nid = ?";
	try {
		this.executeUpdate(sql, id);
	}catch(Exception e){
		e.printStackTrace();
		throw new RuntimeException(e);
	}
}

@Override
public News getById(int id) {
      ResultSet rs = null;
//      String sql = "SELECT `nid`, `ntid`, `ntitle`, `nauthor`, `ncreateDate`, `nsummary`, `tname` FROM `t_new`, `t_topic` WHERE `t_new`.`ntid` = `t_topic`.`tid` AND `t_new`.`ntid` = ? ORDER BY `ncreateDate` DESC";
      String sql = "select * from t_news where nid = ?";
      News e = null;
      try {
         rs = this.executeQuery(sql, id);
         while(rs.next()) {
            e = new News();
            e.setNid(rs.getInt("nid"));
            e.setNtid(rs.getInt("ntid"));
            e.setNtitle(rs.getString("ntitle"));
            e.setNauthor(rs.getString("nauthor"));
            e.setNsummary(rs.getString("nsummary"));
            e.setNcontent(rs.getString("ncontent"));
         }
      } catch (SQLException var9) {
         var9.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, rs);
      }

	return e;
}

@Override
public void update(News n) {
	String sql = "update t_news set ntid = ?, ntitle = ?, nauthor=?, nsummary=?, ncontent = ? where nid = ?";
	
	executeUpdate(sql, n.getNtid(), n.getNtitle(), n.getNauthor(), n.getNsummary(), n.getNcontent(), n.getNid());
	
	// TODO Auto-generated method stub
	
}
}
