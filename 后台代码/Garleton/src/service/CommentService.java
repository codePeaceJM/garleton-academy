package service;

import java.util.ArrayList;

import entity.Comment;

public interface CommentService {
	public boolean add(Comment c);
	public boolean del(int id);
	public ArrayList<Comment> search(String newsname);

}
