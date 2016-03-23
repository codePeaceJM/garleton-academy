package service;

import java.util.ArrayList;

import dao.CasesDAO;
import entity.Cases;

public class CasesServiceImpl implements CasesService {
	CasesDAO casesDAO;
	ArrayList<Cases> casesList;

	public void setCasesDAO(CasesDAO casesDAO) {
		this.casesDAO = casesDAO;
	}

	public boolean add(Cases c) {
		// TODO Auto-generated method stub
		try{
			casesDAO.save(c);
			}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			casesDAO.delete(casesDAO.findById(id));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public ArrayList<Cases> searchAll() {
		// TODO Auto-generated method stub
		return casesList = (ArrayList<Cases>) casesDAO.findAll();
	}

	public ArrayList<Cases> search(String laber) {
		// TODO Auto-generated method stub
		return casesList = (ArrayList<Cases>) casesDAO.findByLaber(laber);
	}

}
