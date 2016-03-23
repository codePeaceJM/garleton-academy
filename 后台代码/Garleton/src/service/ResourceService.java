package service;

import java.util.ArrayList;

import entity.Resource;

public interface ResourceService {
	public boolean add(Resource r);
	public boolean del(int id);
	public ArrayList<Resource> searchAll();
	public ArrayList<Resource> search(String name);
	

}
