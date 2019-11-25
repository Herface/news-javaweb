package org.news.entity;

import java.io.Serializable;

public class User implements Serializable {

   private static final long serialVersionUID = 435894070589975762L;
   private int uid;
   private String uname;
   private String upwd;


   public void setUid(int uid) {
      this.uid = uid;
   }

   public void setUname(String uname) {
      this.uname = uname;
   }

   public void setUpwd(String upwd) {
      this.upwd = upwd;
   }

   public int getUid() {
      return this.uid;
   }

   public String getUname() {
      return this.uname;
   }

   public String getUpwd() {
      return this.upwd;
   }
}
