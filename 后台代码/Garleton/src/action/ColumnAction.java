package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Column;

import service.ColumnService;

public class ColumnAction extends ActionSupport implements ModelDriven<Column>{
	ColumnService columnService;
	ArrayList<Column> columnList;
	private Column column = new Column();
	
	
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
		
		
		if(columnService.add(column))
			return "add_column_success";
		else
			return "add_column_fail";
	}
	public String del(){
		if(columnService.del(column.getId()))
			return "del_column_success";
		else
			return "del_column_fail";
	}
	public String searchAll(){
		
		columnList=columnService.searchAll();
		return "searchAll_column_success";
		
	}
	public String update(){
		System.out.println("add1"+column.getId());
		if(columnService.update(column)){
			return "update_column_success";
		}else{
			return "update_column_fail";
		}
	}

	public Column getModel() {
		// TODO Auto-generated method stub
		return column;
	}
	

}
