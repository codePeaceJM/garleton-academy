package action;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import service.FileServiceImpl;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class UserAction extends ActionSupport implements SessionAware,ModelDriven<User>{

	UserService userService;
	private ArrayList<User> userList;
	private User user=new User();
	private Map<String, Object> session;
	
	/*private File file;

	private String fileFileName;

	private String fileContentType;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}*/
	
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
		if("".equals(user.getName())||user.getName()==null){
			userList=userService.searchAll();
		} else {
			userList=userService.search(user.getName());
		}
		if(userList.isEmpty()){
			return "search_user_fail";
		} else {
			return"search_user_success";
		}
	}
	public String del() {
		if(userService.del(user.getId())){
			return "del_user_success";
		} else {
			return "del_user_fail";
		}
	}
	public String reg() {
		if(userService.reg(user)){
			return "reg_success";
		} else {
			return "reg_fail";
		}
	}
	/*public void upload(){
		new FileServiceImpl().upload(file, "/photo", fileFileName);
	}*/
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
