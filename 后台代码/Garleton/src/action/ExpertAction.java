package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import service.ExpertService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Expert;

public class ExpertAction extends ActionSupport implements ModelDriven<Expert>{
	private Expert expert = new Expert();
	ExpertService expertService;
	ArrayList<Expert> expertList;
	
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
			return "add_expert_success";
		}else{
			return "add_expert_fail";
		}
	}
	
	public String del(){
		if(expertService.del(expert.getId())){
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
			return "update_expert_success";
		}else{
			return "update_expert_fail";
		}
	}

	public Expert getModel() {
		// TODO Auto-generated method stub
		return expert;
	}

}
