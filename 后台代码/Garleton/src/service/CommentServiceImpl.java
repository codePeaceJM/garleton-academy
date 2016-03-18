package service;

import dao.CommentDAO;
import entity.Comment;

public class CommentServiceImpl implements CommentService {
	
	private CommentDAO commentDAO;
	

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	public boolean add(Comment c) {
		// TODO Auto-generated method stub
		try{
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

}
