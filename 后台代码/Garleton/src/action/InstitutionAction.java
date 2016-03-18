package action;

import java.util.ArrayList;

import service.InstitutionService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Institution;

public class InstitutionAction extends ActionSupport implements ModelDriven<Institution>{
	
	
	
	InstitutionService institutionService ;
	ArrayList<Institution> institutionList;
	private Institution institution = new Institution();
	
	public String add(){
		
		institutionService.add(institution);
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
	public String searchAll(){
		institutionList = institutionService.searchAll();
		
		return "searchAll_institution_success";
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
