package service;

import java.util.ArrayList;

import entity.Paper;

public interface PaperService {
	public boolean add(Paper p);
	public boolean del(int id);
	public ArrayList<Paper> searchAll();
	public ArrayList<Paper> searchByCourseName(String coursename);
	public ArrayList<Paper> searchByTitle(String title);
	public ArrayList<Paper> searchByType(String type);
	public boolean update(Paper p);

}
