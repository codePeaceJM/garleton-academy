package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import service.CasesService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Cases;

public class CasesAction extends ActionSupport implements ModelDriven<Cases>{
	CasesService casesService;
	private Cases cases = new Cases();
	ArrayList<Cases> casesList;

	public Cases getCases() {
		return cases;
	}

	public CasesService getCasesService() {
		return casesService;
	}

	public void setCasesService(CasesService casesService) {
		this.casesService = casesService;
	}

	public ArrayList<Cases> getCasesList() {
		return casesList;
	}

	public void setCasesList(ArrayList<Cases> casesList) {
		this.casesList = casesList;
	}

	public void setCases(Cases cases) {
		this.cases = cases;
	}
	
	public String add(){
		if(casesService.add(cases)){
			return "add_cases_success";
		}else{
			return "add_cases_fail";
		}
	}
	
	public String del(){
		if(casesService.del(cases.getId())){
			return "del_cases_success";
		}else{
			return "del_cases_fail";
		}
	}
	
	public String search(){
		if("".equals(cases.getLaber())||cases.getLaber()==null){
			casesList=casesService.searchAll();
		} else {
			casesList=casesService.search(cases.getLaber());
		}
		if(casesList.isEmpty()){
			return "search_cases_fail";
		} else {
			JSONArray jsonArray =  JSONArray.fromObject(casesList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_cases_success";
		}
	}

	public Cases getModel() {
		// TODO Auto-generated method stub
		return cases;
	}

}
