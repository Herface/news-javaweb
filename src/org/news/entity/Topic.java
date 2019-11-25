package org.news.entity;

import java.io.Serializable;

public class Topic implements Serializable {

   private static final long serialVersionUID = 2786883833042050721L;
   private int tid;
   private String tname;


   public int getTid() {
      return this.tid;
   }

   public void setTid(int tid) {
      this.tid = tid;
   }

   public String getTname() {
      return this.tname;
   }

   public void setTname(String tname) {
      this.tname = tname;
   }
}
