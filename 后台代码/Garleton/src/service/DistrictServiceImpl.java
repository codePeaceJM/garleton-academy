package service;

import java.util.ArrayList;

import dao.DistrictDAO;

import entity.District;

public class DistrictServiceImpl implements DistrictService {
	ArrayList<District> districtList;
	
	private DistrictDAO districtDAO;

	public void setDistrictDAO(DistrictDAO districtDAO) {
		this.districtDAO = districtDAO;
	}

	public boolean add(District d) {
		// TODO Auto-generated method stub
		
		try{
			districtDAO.save(d);
			
		}catch(Exception e){
			return false;
		}
		return true;
		
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			districtDAO.delete(districtDAO.findById(id));
			
		}catch(Exception e){
			return false;
		}
		
		return true;
	}

	public ArrayList<District> searchAll() {
		// TODO Auto-generated method stub
		return districtList = (ArrayList<District>) districtDAO.findAll();		
	}

	public ArrayList<District> search(String name) {
		// TODO Auto-generated method stub
		return districtList = (ArrayList<District>) districtDAO.findByName(name);
	}

}
