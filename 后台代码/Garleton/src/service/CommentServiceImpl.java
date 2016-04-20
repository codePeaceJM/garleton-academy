package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.CommentDAO;
import entity.Comment;

public class CommentServiceImpl implements CommentService {
	ArrayList<Comment> commentList;
	private CommentDAO commentDAO;
	

	public ArrayList<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public boolean add(Comment c) {
		// TODO Auto-generated method stub
		try{
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			c.setPublishtime(sdf.format(date));
			commentDAO.save(c);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			commentDAO.delete(commentDAO.findById(id));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public ArrayList<Comment> search(String newsname) {
		// TODO Auto-generated method stub
		return commentList = (ArrayList<Comment>) commentDAO.findByNewsname(newsname);
	}

}
