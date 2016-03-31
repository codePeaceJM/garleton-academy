package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import service.InstitutionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Institution;

public class InstitutionAction extends ActionSupport implements ModelDriven<Institution>{
	
	
	
	InstitutionService institutionService ;
	ArrayList<Institution> institutionList;
	String str;
	private Institution institution = new Institution();
	
	public void add(){
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8"); 	
		JSONObject ins = JSONObject.fromObject(str);
		institution = (Institution)JSONObject.toBean(ins, institution.getClass());
		System.out.println(institution.getName());
		if(institutionService.add(institution)){
			JSONObject jobject = JSONObject.fromObject("{text:'添加成功'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			JSONObject jobject = JSONObject.fromObject("{text:'添加失败'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void del(){
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8"); 
		if(institutionService.del(institution.getId())){
			JSONObject jobject = JSONObject.fromObject("{text:'删除成功'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			JSONObject jobject = JSONObject.fromObject("{text:'删除失败'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void search(){
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8"); 
		if("".equals(institution.getName())||institution.getName()==null){
			institutionList = institutionService.searchAll();
		}else{
			institutionList = institutionService.search(institution.getName());
		}
		if(institutionList.isEmpty()){
			JSONObject jobject = JSONObject.fromObject("{text:'找不到机构'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(institutionList);
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
	public InstitutionService getInstitutionService() {
		return institutionService;
	}
	public void setInstitutionService(InstitutionService institutionService) {
		this.institutionService = institutionService;
	}
	public ArrayList<Institution> getInstitutionList() {
		return institutionList;
	}
	public void setInstitutionList(ArrayList<Institution> institutionList) {
		this.institutionList = institutionList;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Institution getModel() {
		// TODO Auto-generated method stub
		
		return institution;
	}
	

}
