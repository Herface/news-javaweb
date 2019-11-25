package org.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.news.dao.BaseDao;
import org.news.dao.CommentDao;
import org.news.entity.Comment;

public class CommentDaoImpl extends BaseDao implements CommentDao {

	@Override
	public List<Comment> queryAll(int cnid) {
		// TODO Auto-generated method stub
		String sql = "select * from t_comment where cnid =  ? order by cdate desc";
		
		ResultSet rs = super.executeQuery(sql, cnid);
		List<Comment> comments = new ArrayList<>();
		try {
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setCid(rs.getInt("cid"));
				comment.setCnid(rs.getInt("cnid"));
				comment.setCauthor(rs.getString("cauthor"));
				comment.setCcontent(rs.getString("ccontent"));
				comment.setCdate(rs.getDate("cdate"));
				comment.setCip(rs.getString("cip"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comments;
	}

	@Override
	public void add(Comment comment) {
		// TODO Auto-generated method stub
		String sql = "insert into t_comment(cnid, ccontent, cdate, cip, cauthor)"
				+ "values(?, ?, ?, ?, ?)";
		super.executeUpdate(sql, 
				comment.getCnid(),
				comment.getCcontent(),
				comment.getCdate(),
				comment.getCip(),
				comment.getCauthor());
		
	}
	

}
