package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import service.PaperService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Paper;

public class PaperAction extends ActionSupport implements ModelDriven<Paper> {
	private Paper paper = new Paper();
	PaperService paperService;
	ArrayList<Paper> paperList;

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
			return "add_paper_success";
		} else {
			return "add_paper_fail";
		}
	}

	public String del() {
		if (paperService.del(paper.getId())) {
			return "del_paper_success";

		} else {
			return "del_paper_fail";
		}
	}

	public String update() {
		if (paperService.update(paper)) {
			return "update_paper_success";
		} else {
			return "update_paper_fail";
		}

	}

	public String search() {
		if ("".equals(paper.getCoursename()) || paper.getCoursename() == null) {
			paperList = paperService.searchAll();
		} else {
			paperList = paperService.search(paper.getCoursename());
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

}
