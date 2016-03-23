package service;

import java.util.ArrayList;

import entity.Cases;

public interface CasesService {
	public boolean del(int id);
	public boolean add(Cases c);
	public ArrayList<Cases> searchAll();
	public ArrayList<Cases> search(String laber);

}
