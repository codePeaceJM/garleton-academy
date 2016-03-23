package service;

import java.util.ArrayList;

import entity.Expert;

public interface ExpertService {
	public boolean add(Expert e);
	public boolean del(int id);
	public ArrayList<Expert> searchAll();
	public ArrayList<Expert> search(String name);
	public boolean update(Expert e);
	

}
