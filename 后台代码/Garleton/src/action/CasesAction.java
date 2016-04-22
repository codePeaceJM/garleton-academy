package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.CasesService;
import service.LogService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Cases;

public class CasesAction extends ActionSupport implements SessionAware,
		ModelDriven<Cases> {
	LogService logService;
	CasesService casesService;
	private Cases cases = new Cases();
	private ArrayList<Cases> casesList;
	private Map<String, Object> session;

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

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

	public void add() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		if (casesService.add(cases)) {
			logService.add((Integer) session.get("id"), 1, "cases");
			JSONObject jobject = JSONObject.fromObject("{text:'success'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JSONObject jobject = JSONObject.fromObject("{text:'failed'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void del() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		if (casesService.del(cases.getId())) {
			logService.add((Integer) session.get("id"), 2, "cases");
			JSONObject jobject = JSONObject.fromObject("{text:'success'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JSONObject jobject = JSONObject.fromObject("{text:'failed'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void search() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		if ("".equals(cases.getLaber()) || cases.getLaber() == null) {
			casesList = casesService.searchAll();
		} else {
			casesList = casesService.search(cases.getLaber());
		}
		if (casesList.isEmpty()) {
			JSONObject jobject = JSONObject.fromObject("{text:'failed'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JSONArray jsonArray = JSONArray.fromObject(casesList);
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Cases getModel() {
		// TODO Auto-generated method stub
		return cases;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
