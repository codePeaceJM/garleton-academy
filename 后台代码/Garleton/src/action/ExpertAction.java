package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.ExpertService;
import service.LogService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Expert;

public class ExpertAction extends ActionSupport implements SessionAware,ModelDriven<Expert>{
	LogService logService;
	ExpertService expertService;
	ArrayList<Expert> expertList;
	private Expert expert = new Expert();
	private Map<String, Object> session;
	
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public ExpertService getExpertService() {
		return expertService;
	}

	public void setExpertService(ExpertService expertService) {
		this.expertService = expertService;
	}

	public ArrayList<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(ArrayList<Expert> expertList) {
		this.expertList = expertList;
	}

	public String add(){
		if(expertService.add(expert)){
			logService.add((Integer) session.get("id"), 1, "expert");
			return "add_expert_success";
		}else{
			return "add_expert_fail";
		}
	}
	
	public String del(){
		if(expertService.del(expert.getId())){
			logService.add((Integer) session.get("id"), 2, "expert");
			return "del_expert_success";
		}else{
			return "del_expert_fail";
		}
	}
	
	public String search(){
		if("".equals(expert.getName())||expert.getName()==null){
			expertList=expertService.searchAll();			
		}else{
			expertList=expertService.search(expert.getName());
		}
		if(expertList.isEmpty()){
			return "search_expert_fail";
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(expertList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_expert_success";
		}
	}
	
	public String update(){
		if(expertService.update(expert)){
			logService.add((Integer) session.get("id"), 3, "expert");
			return "update_expert_success";
		}else{
			return "update_expert_fail";
		}
	}

	public Expert getModel() {
		// TODO Auto-generated method stub
		return expert;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	

}
