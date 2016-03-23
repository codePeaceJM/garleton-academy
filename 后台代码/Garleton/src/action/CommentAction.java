package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import service.CommentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Comment;

public class CommentAction extends ActionSupport implements ModelDriven<Comment>{
	ArrayList<Comment> commentList;
	CommentService commentService;
	private Comment comment = new Comment();
	
	
	public ArrayList<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<Comment> commentList) {
		this.commentList = commentList;
	}


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
	public String search(){
		commentList=commentService.search(comment.getNewsname());
		if(commentList.isEmpty()){
			return "search_comment_fail";
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(commentList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_comment_success";
		}
	}

	public Comment getModel() {
		// TODO Auto-generated method stub
		return comment;
	}

}
