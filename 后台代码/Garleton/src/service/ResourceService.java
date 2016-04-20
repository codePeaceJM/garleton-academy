package service;

import java.util.ArrayList;

import entity.Resource;

public interface ResourceService {
	public boolean add(Resource r);
	public boolean del(int id);
	public ArrayList<Resource> searchAll();
	public ArrayList<Resource> searchByName(String name);
	public ArrayList<Resource> searchByType(String type);
	public ArrayList<Resource> searchBySource(String source);
}
