package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import service.KnowledgeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Knowledge;

public class KnowledgeAction extends ActionSupport implements ModelDriven<Knowledge>{
	private Knowledge knowledge = new Knowledge();
	KnowledgeService knowledgeService;
	ArrayList<Knowledge> knowledgeList;

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
			return "add_knowledge_success";
		}else{
			return "add_knowledge_fail";
		}
	}
	public String del(){
		if(knowledgeService.del(knowledge.getId())){
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

}
