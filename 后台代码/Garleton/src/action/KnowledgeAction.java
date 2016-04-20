package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.KnowledgeService;
import service.LogService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Knowledge;

public class KnowledgeAction extends ActionSupport implements SessionAware,ModelDriven<Knowledge>{
	
	private Knowledge knowledge = new Knowledge();
	private Map<String, Object> session;
	LogService logService;
	KnowledgeService knowledgeService;
	ArrayList<Knowledge> knowledgeList;

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	public KnowledgeService getKnowledgeService() {
		return knowledgeService;
	}

	public void setKnowledgeService(KnowledgeService knowledgeService) {
		this.knowledgeService = knowledgeService;
	}

	
	public ArrayList<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	public void setKnowledgeList(ArrayList<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	public String add(){
		if(knowledgeService.add(knowledge)){
			logService.add((Integer) session.get("id"), 1, "knowledge");
			return "add_knowledge_success";
		}else{
			return "add_knowledge_fail";
		}
	}
	public String del(){
		if(knowledgeService.del(knowledge.getId())){
			logService.add((Integer) session.get("id"), 2, "knowledge");
			return "del_knowledge_success";
		}else{
			return "del_knowledge_fail";
		}
	}
	public String search(){
		if("".equals(knowledge.getName())||knowledge.getName()==null){
			knowledgeList=knowledgeService.searchAll();
		}else{
			knowledgeList=knowledgeService.search(knowledge.getName());
		}
		if(knowledgeList.isEmpty()){
			return "search_knowledge_fail";
			
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(knowledgeList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_knowledge_success";
		}
	}

	public Knowledge getModel() {
		// TODO Auto-generated method stub
		return knowledge;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
