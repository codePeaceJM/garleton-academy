package service;

import java.util.ArrayList;

import entity.Paper;

public interface PaperService {
	public boolean add(Paper p);
	public boolean del(int id);
	public ArrayList<Paper> searchAll();
	public ArrayList<Paper> search(String coursename);
	public boolean update(Paper p);

}
