package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.ColumnDAO;

import entity.Column;

public class ColumnServiceImpl implements ColumnService {
	ArrayList<Column> columnList;
	
	private ColumnDAO columnDAO;

	public void setColumnDAO(ColumnDAO columnDAO) {
		this.columnDAO = columnDAO;
	}

	public boolean add(Column c) {
		// TODO Auto-generated method stub
		try{
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			c.setPublishtime(sdf.format(date));
			columnDAO.save(c);
		}catch(Exception e){
			return false;
		}
		return true;
		
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			columnDAO.delete(columnDAO.findById(id));
			
		}catch(Exception e){
			return false;
		}
		
		return true;
	}

	public ArrayList<Column> searchAll() {
		// TODO Auto-generated method stub
		return columnList = (ArrayList<Column>) columnDAO.findAll();
	}

	public boolean update(Column c) {
		// TODO Auto-generated method stub
		try{
			columnDAO.update(c);
		}catch(Exception e){
			return false;
		}
		return true;		
	}

	public ArrayList<Column> search(String name) {
		// TODO Auto-generated method stub
		return columnList = (ArrayList<Column>) columnDAO.findByName(name);
	}

}
