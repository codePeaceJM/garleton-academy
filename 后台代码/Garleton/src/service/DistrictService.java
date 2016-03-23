package service;

import java.util.ArrayList;

import entity.District;

public interface DistrictService {
	
	public boolean add(District d);
	public ArrayList<District> searchAll();
	public ArrayList<District> search(String name);
	public boolean del(int id);

}
