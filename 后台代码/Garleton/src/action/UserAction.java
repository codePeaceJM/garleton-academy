package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class UserAction extends ActionSupport implements SessionAware,ModelDriven<User>{
	
	UserService userService;
	private ArrayList<User> userList;
	private User user=new User();
	private Map<String, Object> session;
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String log(){
		if(userService.log(user.getName(), user.getPwd())){
			session.put("name", user.getName());
			return "log_success";
		}
		return "log_fail";
	}
	public String search(){
		return"";
	}
	public String searchAll(){
		return"";
	}
	
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
}
