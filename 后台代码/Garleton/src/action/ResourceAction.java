package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.LogService;
import service.ResourceService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Resource;

public class ResourceAction extends ActionSupport implements SessionAware,ModelDriven<Resource>{
	ResourceService resourceService;
	private Map<String, Object> session;
	LogService logService;
	private Resource resource = new Resource();
	ArrayList<Resource> resourceList;

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public ArrayList<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(ArrayList<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	public String add(){
		
		if(resourceService.add(resource)){
			logService.add((Integer) session.get("id"), 1, "resource");
			return "add_resource_success";
			
		}else{
			return "add_resource_fail";
		}
	}
	public String del(){
		if(resourceService.del(resource.getId())){
			logService.add((Integer) session.get("id"), 2, "resource");
			return "del_resource_success";
			
		}else{
			return "del_resource_fail";
		}
		
	}
	public String searchByName(){
		if("".equals(resource.getName())||resource.getName()==null){
			resourceList=resourceService.searchAll();
			
		}else{
			resourceList=resourceService.searchByName(resource.getName());
		}
		if(resourceList.isEmpty()){
			return "search_resource_fail";
			
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(resourceList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_resource_success";
		}
		
	}public String searchByType(){
		if("".equals(resource.getName())||resource.getName()==null){
			resourceList=resourceService.searchAll();
			
		}else{
			resourceList=resourceService.searchByType(resource.getType());
		}
		if(resourceList.isEmpty()){
			return "search_resource_fail";
			
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(resourceList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_resource_success";
		}
		
	}
	public String searchBySource(){
		if("".equals(resource.getName())||resource.getName()==null){
			resourceList=resourceService.searchAll();
			
		}else{
			resourceList=resourceService.searchBySource(resource.getSource());
		}
		
		if(resourceList.isEmpty()){
			return "search_resource_fail";
			
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(resourceList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_resource_success";
		}
	}

	public Resource getModel() {
		// TODO Auto-generated method stub
		return resource;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}


}
