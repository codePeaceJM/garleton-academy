package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import net.sf.json.JSONArray;

import service.DistrictService;
import service.LogService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.District;

public class DistrictAction extends ActionSupport implements SessionAware,ModelDriven<District>{
	LogService logService;
	DistrictService districtService ;
	ArrayList<District> districtList;
	private District district = new District(); 
	private Map<String, Object> session;
	
	
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public DistrictService getDistrictService() {
		return districtService;
	}
	public void setDistrictService(DistrictService districtService) {
		this.districtService = districtService;
	}
	public ArrayList<District> getDistrictList() {
		return districtList;
	}
	public void setDistrictList(ArrayList<District> districtList) {
		this.districtList = districtList;
	}
	
	public String add(){
		
		if(districtService.add(district)){
			logService.add((Integer) session.get("id"), 1, "district");
			return "add_district_success";
		}
		else
			return "add_district_fail";
	}
	
	public String del(){
		if(districtService.del(district.getId())){
			logService.add((Integer) session.get("id"), 2, "district");
			return "del_district_success";
		}
		else
			return "del_district_fail";
	}
	
	public String search(){
		
		if("".equals(district.getName())||district.getName()==null){
			districtList=districtService.searchAll();
		} else {
			districtList=districtService.search(district.getName());
		}
		JSONArray jsonArray =  JSONArray.fromObject(districtList);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8"); 
		try {
			response.getWriter().print(jsonArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(districtList.isEmpty()){
			return "search_district_fail";
		} else {
			return "search_district_success";
		}
		
		
		
	}
	
	public void setDistrict(District district) {
		this.district = district;
	}
	public District getDistrict() {
		return district;
	}
	public District getModel() {
		// TODO Auto-generated method stub
		return district;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	

}
