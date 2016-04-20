package service;

import java.util.ArrayList;

import dao.ResourceDAO;
import entity.Resource;

public class ResourceServiceImpl implements ResourceService {
	ResourceDAO resourceDAO;
	ArrayList<Resource> resourceList;

	public ResourceDAO getResourceDAO() {
		return resourceDAO;
	}

	public void setResourceDAO(ResourceDAO resourceDAO) {
		this.resourceDAO = resourceDAO;
	}

	public ArrayList<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(ArrayList<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	public boolean add(Resource r) {
		// TODO Auto-generated method stub
		try{
			resourceDAO.save(r);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			resourceDAO.delete(resourceDAO.findById(id));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public ArrayList<Resource> searchAll() {
		// TODO Auto-generated method stub
		return resourceList=(ArrayList<Resource>) resourceDAO.findAll();
	}

	public ArrayList<Resource> searchByName(String name) {
		// TODO Auto-generated method stub
		return resourceList=(ArrayList<Resource>) resourceDAO.findByName(name);
	}
	

	public ArrayList<Resource> searchBySource(String source) {
		// TODO Auto-generated method stub
		return resourceList=(ArrayList<Resource>) resourceDAO.findBySource(source);
	}

	public ArrayList<Resource> searchByType(String type) {
		// TODO Auto-generated method stub
		return resourceList=(ArrayList<Resource>) resourceDAO.findByType(type);
	}
}
