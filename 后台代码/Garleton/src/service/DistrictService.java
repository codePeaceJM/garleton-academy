package service;

import java.util.ArrayList;

import entity.District;

public interface DistrictService {
	
	public boolean add(District d);
	public ArrayList<District> searchAll();
	public boolean del(int id);

}
