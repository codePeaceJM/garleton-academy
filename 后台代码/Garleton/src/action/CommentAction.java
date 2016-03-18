package action;

import service.CommentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Comment;

public class CommentAction extends ActionSupport implements ModelDriven<Comment>{
	CommentService commentService;
	private Comment comment = new Comment();
	
	
	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String add(){
		if(commentService.add(comment)){
			return "add_comment_success";
			
		}else{
			return "add_comment_fail";
		}
	}
	public String del(){
		if(commentService.del(comment.getId())){
			return "del_comment_success";
			
		}else{
			return "del_comment_fail";
		}
	}

	public Comment getModel() {
		// TODO Auto-generated method stub
		return comment;
	}

}
