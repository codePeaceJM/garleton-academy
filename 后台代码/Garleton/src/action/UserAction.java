package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.LogService;
import service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class UserAction extends ActionSupport implements SessionAware,ModelDriven<User>{

	UserService userService;
	LogService logService;
	private ArrayList<User> userList;
	private User user=new User();
	private Map<String, Object> session;
	
	private File file;

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
	}
	
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
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public String log(){
		if(userService.log(user.getName(), user.getPwd())){
			user=userService.search(user.getName()).get(0);
			session.put("name", user.getName());
			session.put("id", user.getId());
			return "log_admin_success";
		}
		return "log_fail";
	}
	public void search(){
		if("".equals(user.getName())||user.getName()==null){
			userList=userService.searchAll();
		} else {
			userList=userService.search(user.getName());
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8"); 
		if(userList.isEmpty()){
			try {
				JSONObject jobject = JSONObject.fromObject("{text:'找不到用户'}");
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JSONArray jsonArray =  JSONArray.fromObject(userList);
			
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void del() {
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8"); 
		if(userService.del(user.getId())){
			logService.add((Integer)session.get("id"),2,"user");
			JSONObject jobject = JSONObject.fromObject("{text:'删除成功'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JSONObject jobject = JSONObject.fromObject("{text:'删除失败'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String reg() {
		if(userService.reg(user)){
			user=userService.search(user.getName()).get(0);
			session.put("name", user.getName());
			session.put("id", user.getId());
			logService.add((Integer)session.get("id"),1,"user");
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
