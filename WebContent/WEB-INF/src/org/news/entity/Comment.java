package org.news.entity;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {

   private static final long serialVersionUID = -9015266392799849479L;
   private int cid;
   private int cnid;
   private String ccontent;
   private Date cdate;
   private String cip;
   private String cauthor;


   public int getCid() {
      return this.cid;
   }

   public void setCid(int cid) {
      this.cid = cid;
   }

   public int getCnid() {
      return this.cnid;
   }

   public void setCnid(int cnid) {
      this.cnid = cnid;
   }

   public String getCcontent() {
      return this.ccontent;
   }

   public void setCcontent(String ccontent) {
      this.ccontent = ccontent;
   }

   public Date getCdate() {
      return this.cdate;
   }

   public void setCdate(Date cdate) {
      this.cdate = cdate;
   }

   public String getCip() {
      return this.cip;
   }

   public void setCip(String cip) {
      this.cip = cip;
   }

   public String getCauthor() {
      return this.cauthor;
   }

   public void setCauthor(String cauthor) {
      this.cauthor = cauthor;
   }
}
