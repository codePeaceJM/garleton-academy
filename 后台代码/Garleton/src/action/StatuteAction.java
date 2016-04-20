package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.LogService;
import service.StatuteService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Statute;

public class StatuteAction extends ActionSupport implements SessionAware,ModelDriven<Statute>{
	private Statute statute = new Statute();
	private Map<String, Object> session;
	LogService logService;
	ArrayList<Statute> statuteList;
	StatuteService statuteService;
	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public String add(){
		if(statuteService.add(statute)){
			logService.add((Integer) session.get("id"), 1, "statute");
			return "add_statute_success";
		}else{
			return "add_statute_fail";
		}
	}
	
	public String del(){
		if(statuteService.del(statute.getId())){
			logService.add((Integer) session.get("id"), 2, "statute");
			return "del_statute_success";
		}else{
			return "del_statute_fail";
		}
	}
	
	public String search(){
		if("".equals(statute.getName())||statute.getName()==null){
			statuteList=statuteService.searchAll();
		}else{
			statuteList=statuteService.search(statute.getName());
		}
		if(statuteList.isEmpty()){
			return "search_statute_fail";
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(statuteList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_statute_success";
		}
	}

	public Statute getStatute() {
		return statute;
	}

	public void setStatute(Statute statute) {
		this.statute = statute;
	}

	public ArrayList<Statute> getStatuteList() {
		return statuteList;
	}

	public void setStatuteList(ArrayList<Statute> statuteList) {
		this.statuteList = statuteList;
	}

	public StatuteService getStatuteService() {
		return statuteService;
	}

	public void setStatuteService(StatuteService statuteService) {
		this.statuteService = statuteService;
	}

	public Statute getModel() {
		// TODO Auto-generated method stub
		return statute;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
