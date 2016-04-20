package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.LogService;
import service.PaperService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import entity.Paper;

public class PaperAction extends ActionSupport implements SessionAware,ModelDriven<Paper> {
	private Paper paper = new Paper();
	private Map<String , Object> session;
	PaperService paperService;
	LogService logService;
	private ArrayList<Paper> paperList;

	
	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public PaperService getPaperService() {
		return paperService;
	}

	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}

	public ArrayList<Paper> getPaperList() {
		return paperList;
	}

	public void setPaperList(ArrayList<Paper> paperList) {
		this.paperList = paperList;
	}

	public String add() {
		if (paperService.add(paper)) {
			logService.add((Integer) session.get("id"), 1, "paper");
			return "add_paper_success";
		} else {
			return "add_paper_fail";
		}
	}

	public String del() {
		if (paperService.del(paper.getId())) {
			logService.add((Integer) session.get("id"),2, "paper");
			return "del_paper_success";

		} else {
			return "del_paper_fail";
		}
	}

	public String update() {
		if (paperService.update(paper)) {
			logService.add((Integer) session.get("id"), 3, "paper");
			return "update_paper_success";
		} else {
			return "update_paper_fail";
		}

	}

	public String searchByCourseName() {
		if ("".equals(paper.getCoursename()) || paper.getCoursename() == null) {
			paperList = paperService.searchAll();
		} else {
			paperList = paperService.searchByCourseName(paper.getCoursename());
		}		
		
		if (paperList.isEmpty()) {
			return "search_paper_fail";
		} else {
			JSONArray jsonArray = JSONArray.fromObject(paperList);
			HttpServletResponse response = (HttpServletResponse) ActionContext
					.getContext().get(ServletActionContext.HTTP_RESPONSE);
			response.setCharacterEncoding("UTF-8");
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_paper_success";
		}
		
		
	}
	public String searchByTitle() {
		if ("".equals(paper.getCoursename()) || paper.getCoursename() == null) {
			paperList = paperService.searchAll();
		} else {
			paperList = paperService.searchByTitle(paper.getTitle());
		}		
		
		if (paperList.isEmpty()) {
			return "search_paper_fail";
		} else {
			JSONArray jsonArray = JSONArray.fromObject(paperList);
			HttpServletResponse response = (HttpServletResponse) ActionContext
					.getContext().get(ServletActionContext.HTTP_RESPONSE);
			response.setCharacterEncoding("UTF-8");
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_paper_success";
		}
		
		
	}
	public String searchByType() {
		if ("".equals(paper.getCoursename()) || paper.getCoursename() == null) {
			paperList = paperService.searchAll();
		} else {
			paperList = paperService.searchByType(paper.getType());
		}		
		
		if (paperList.isEmpty()) {
			return "search_paper_fail";
		} else {
			JSONArray jsonArray = JSONArray.fromObject(paperList);
			HttpServletResponse response = (HttpServletResponse) ActionContext
					.getContext().get(ServletActionContext.HTTP_RESPONSE);
			response.setCharacterEncoding("UTF-8");
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_paper_success";
		}
		
		
	}


	public Paper getModel() {
		// TODO Auto-generated method stub
		return paper;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
