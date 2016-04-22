package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.LogService;
import service.StatuteService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Statute;

public class StatuteAction extends ActionSupport implements SessionAware,
		ModelDriven<Statute> {
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

	public void add() {
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		if (statuteService.add(statute)) {
			logService.add((Integer) session.get("id"), 1, "statute");
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
		if (statuteService.del(statute.getId())) {
			logService.add((Integer) session.get("id"), 2, "statute");
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
		if ("".equals(statute.getName()) || statute.getName() == null) {
			statuteList = statuteService.searchAll();
		} else {
			statuteList = statuteService.search(statute.getName());
		}
		if (statuteList.isEmpty()) {
			JSONObject jobject = JSONObject.fromObject("{text:'failed'}");
			try {
				response.getWriter().print(jobject);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JSONArray jsonArray = JSONArray.fromObject(statuteList);
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
