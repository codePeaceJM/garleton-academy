package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Column;

import service.ColumnService;
import service.LogService;

public class ColumnAction extends ActionSupport implements SessionAware,ModelDriven<Column>{
	LogService logService;
	ColumnService columnService;
	ArrayList<Column> columnList;
	private Column column = new Column();
	private Map<String, Object> session;
	
	
	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public ColumnService getColumnService() {
		return columnService;
	}

	public void setColumnService(ColumnService columnService) {
		this.columnService = columnService;
	}

	public ArrayList<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(ArrayList<Column> columnList) {
		this.columnList = columnList;
	}
	public String add(){
				
		if(columnService.add(column)){
			logService.add((Integer) session.get("id"), 1, "column");
			return "add_column_success";
		}
		else
			return "add_column_fail";
	}
	public String del(){
		if(columnService.del(column.getId())){
			logService.add((Integer) session.get("id"), 2, "column");
		
			return "del_column_success";
		}
		else
			return "del_column_fail";
	}
	public String search(){
		if("".equals(column.getName())||column.getName()==null){
			columnList=columnService.searchAll();
		}else{
			columnList=columnService.search(column.getName());
		}
		if(columnList.isEmpty()){
			return "search_column_fail";
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(columnList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_column_success";
		}
	}
	public String update(){
		
		if(columnService.update(column)){
			logService.add((Integer) session.get("id"), 3, "column");
			return "update_column_success";
		}else{
			return "update_column_fail";
		}
	}

	public Column getModel() {
		// TODO Auto-generated method stub
		return column;
	}

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	

}
