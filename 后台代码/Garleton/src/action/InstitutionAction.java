package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import service.InstitutionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Institution;

public class InstitutionAction extends ActionSupport implements ModelDriven<Institution>{
	
	
	
	InstitutionService institutionService ;
	ArrayList<Institution> institutionList;
	private Institution institution = new Institution();
	
	public String add(){
		
		
		if(institutionService.add(institution)){
			
			return "add_institution_success";
			
		}else{
			return "add_institution_fail";
		}
	}
	public String del(){
		if(institutionService.del(institution.getId())){
			return "del_institution_success";
			
		}else{
			return "add_institution_fail";
		}
	}
	public String search(){
		if("".equals(institution.getName())||institution.getName()==null){
			institutionList = institutionService.searchAll();
		}else{
			institutionList = institutionService.search(institution.getName());
		}
		if(institutionList.isEmpty()){
			return "search_institution_fail";
			
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(institutionList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_institution_success";
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
	public Institution getModel() {
		// TODO Auto-generated method stub
		
		return institution;
	}
	

}
