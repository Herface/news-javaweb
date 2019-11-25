package org.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.news.util.ConfigManager;

public class BaseDao {

   private static String driver = ConfigManager.getProperty("jdbc.sqlserver.driver");
   private static String url = ConfigManager.getProperty("jdbc.sqlserver.url");
   private static String user = ConfigManager.getProperty("jdbc.sqlserver.username");
   private static String password = ConfigManager.getProperty("jdbc.sqlserver.password");
   protected Connection conn;
   static {
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException var1) {
         var1.printStackTrace();
      }

   }

   public Connection getConnection() {
      try {
         if(this.conn == null || this.conn.isClosed()) {
            this.conn = DriverManager.getConnection(url, user, password);
         }
      } catch (SQLException var2) {
         var2.printStackTrace();
      }

      return this.conn;
   }

   public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
      try {
         if(rs != null && !rs.isClosed()) {
            rs.close();
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      try {
         if(stmt != null && !stmt.isClosed()) {
            stmt.close();
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      try {
         if(conn != null && !conn.isClosed()) {
            conn.close();
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   protected int executeUpdate(String sql, Object ... params) {
      int result = 0;
      this.conn = this.getConnection();
      PreparedStatement pstmt = null;

      try {
         pstmt = this.conn.prepareStatement(sql);
         for(int e = 0; e < params.length; ++e) {
            pstmt.setObject(e + 1, params[e]);
         }

         result = pstmt.executeUpdate();
      } catch (SQLException var9) {
         var9.printStackTrace();
         throw new RuntimeException(var9);
      } finally {
         this.closeAll((Connection)null, pstmt, (ResultSet)null);
      }

      return result;
   }

   protected ResultSet executeQuery(String sql, Object ... params) {
      this.conn = this.getConnection();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         pstmt = this.conn.prepareStatement(sql);

         for(int e = 0; e < params.length; ++e) {
            pstmt.setObject(e + 1, params[e]);
         }

         rs = pstmt.executeQuery();
      } catch (SQLException var6) {
         var6.printStackTrace();
      }

      return rs;
   }
   public static void main(String[] args) {
	   BaseDao baseDao = new BaseDao();
	   System.out.println(baseDao.getConnection());
	   
   }
}
