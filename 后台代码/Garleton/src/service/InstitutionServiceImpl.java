package service;

import java.util.ArrayList;


import dao.InstitutionDAO;


import entity.Institution;

public class InstitutionServiceImpl implements InstitutionService {
	ArrayList<Institution> institutionList;
	

	private InstitutionDAO institutionDAO;
	
	public void setInstitutionDAO(InstitutionDAO institutionDAO) {
		this.institutionDAO = institutionDAO;
	}

	public boolean add(Institution i) {
		// TODO Auto-generated method stub
		try{
			institutionDAO.save(i);
			
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			institutionDAO.delete(institutionDAO.findById(id));
			return true;
		}catch(Exception e){
			return false;
		}
		
	}

	public ArrayList<Institution> searchAll() {
		// TODO Auto-generated method stub
		return institutionList = (ArrayList<Institution>) institutionDAO.findAll();
	}

}
