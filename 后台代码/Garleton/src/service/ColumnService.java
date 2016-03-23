package service;

import java.util.ArrayList;

import entity.Column;

public interface ColumnService {
	
	public boolean add(Column c);
	public boolean del(int id);
	public ArrayList<Column> searchAll();
	public ArrayList<Column> search(String name);
	public boolean update(Column c);

}
