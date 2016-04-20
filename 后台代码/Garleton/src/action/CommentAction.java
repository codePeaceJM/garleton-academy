package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.CommentService;
import service.LogService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Comment;

public class CommentAction extends ActionSupport implements SessionAware,ModelDriven<Comment>{
	LogService logService;
	ArrayList<Comment> commentList;
	CommentService commentService;
	private Comment comment = new Comment();
	private Map<String, Object> session;
	
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

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
			logService.add((Integer) session.get("id"), 1, "comment");
			return "add_comment_success";
			
		}else{
			return "add_comment_fail";
		}
	}
	public String del(){
		if(commentService.del(comment.getId())){
			logService.add((Integer) session.get("id"), 2, "comment");
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
