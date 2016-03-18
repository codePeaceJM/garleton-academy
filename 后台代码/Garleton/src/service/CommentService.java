package service;

import entity.Comment;

public interface CommentService {
	public boolean add(Comment c);
	public boolean del(int id);

}
