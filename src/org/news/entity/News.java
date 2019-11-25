package org.news.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class News implements Serializable {

   private static final long serialVersionUID = 8456547789761324251L;
   private int nid;
   private int ntid;
   private String ntname;
   private List<Comment> comments;
   private String ntitle;
   private String nauthor;
   private Date ncreatedate;
   private String npicpath;
   private String ncontent;
   private Date nmodifydate;
   private String nsummary;


   public String getNtname() {
      return this.ntname;
   }

   public void setNtname(String ntname) {
      this.ntname = ntname;
   }

   public int getNid() {
      return this.nid;
   }

   public void setNid(int nid) {
      this.nid = nid;
   }

   public int getNtid() {
      return this.ntid;
   }

   public void setNtid(int ntid) {
      this.ntid = ntid;
   }

   public String getNtitle() {
      return this.ntitle;
   }

   public void setNtitle(String ntitle) {
      this.ntitle = ntitle;
   }

   public String getNauthor() {
      return this.nauthor;
   }

   public void setNauthor(String nauthor) {
      this.nauthor = nauthor;
   }

   public Date getNcreatedate() {
      return this.ncreatedate;
   }

   public void setNcreatedate(Date ncreatedate) {
      this.ncreatedate = ncreatedate;
   }

   public String getNpicpath() {
      return this.npicpath;
   }

   public void setNpicpath(String npicpath) {
      this.npicpath = npicpath;
   }

   public String getNcontent() {
      return this.ncontent;
   }

   public void setNcontent(String ncontent) {
      this.ncontent = ncontent;
   }

   public Date getNmodifydate() {
      return this.nmodifydate;
   }

   public void setNmodifydate(Date nmodifydate) {
      this.nmodifydate = nmodifydate;
   }

   public String getNsummary() {
      return this.nsummary;
   }

   public void setNsummary(String nsummary) {
      this.nsummary = nsummary;
   }

   public List getComments() {
      return this.comments;
   }

   public void setComments(List comments) {
      this.comments = comments;
   }

@Override
public String toString() {
	return "News [nid=" + nid + ", ntid=" + ntid + ", ntname=" + ntname + ", comments=" + comments + ", ntitle="
			+ ntitle + ", nauthor=" + nauthor + ", ncreatedate=" + ncreatedate + ", npicpath=" + npicpath
			+ ", ncontent=" + ncontent + ", nmodifydate=" + nmodifydate + ", nsummary=" + nsummary + "]";
}
   
   
}
