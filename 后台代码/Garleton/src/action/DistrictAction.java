package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import service.DistrictService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.District;

public class DistrictAction extends ActionSupport implements ModelDriven<District>{
	
	DistrictService districtService ;
	ArrayList<District> districtList;
	private District district = new District(); 
	
	
	
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
		if(districtService.add(district))
			return "add_district_success";
		else
			return "add_district_fail";
	}
	public String del(){
		if(districtService.del(district.getId()))
			return "del_district_success";
		else
			return "del_district_fail";
	}
	
	public String searchAll(){
		
		districtList=districtService.searchAll();
		JSONArray jsonArray =  JSONArray.fromObject(districtList);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8"); 
		try {
			response.getWriter().print(jsonArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "searchAll_district_success";
		
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
	

}
