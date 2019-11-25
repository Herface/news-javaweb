package org.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.news.dao.BaseDao;
import org.news.dao.UserDao;
import org.news.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

   public User findUser(User u) {
      ResultSet rs = null;
      User user = null;
      String sql = "select * from t_user where uname=? and upwd=?";

      try {
         rs = this.executeQuery(sql, u.getUname(), u.getUpwd());
         if(rs.next()) {
//            user = new User();
//            user.setUid(rs.getInt("uid"));
//            user.setUname();
//            user.setUpwd(password);
        	 user = u;
         }
      } catch (SQLException var10) {
         var10.printStackTrace();
      } finally {
         this.closeAll(this.conn, (Statement)null, rs);
      }
      return user;
   }

@Override
public void add(User u) {
	// TODO Auto-generated method stub
	String sql = "insert into t_user(uname, upwd)values(?, ?)";
	
	executeUpdate(sql, u.getUname(), u.getUpwd());
	
}
}
