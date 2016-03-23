package service;

import java.util.ArrayList;


import entity.Institution;

public interface InstitutionService {
	
	public boolean add(Institution i);
	public ArrayList<Institution> searchAll();
	public ArrayList<Institution> search(String name);
	public boolean del(int id);

}
