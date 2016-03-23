package service;

import java.util.ArrayList;

import dao.ExpertDAO;

import entity.Expert;

public class ExpertServiceImpl implements ExpertService {
	ExpertDAO expertDAO;
	ArrayList<Expert> expertList;
	
	
	public ExpertDAO getExpertDAO() {
		return expertDAO;
	}

	public void setExpertDAO(ExpertDAO expertDAO) {
		this.expertDAO = expertDAO;
	}

	public ArrayList<Expert> getExpertList() {
		return expertList;
	}

	public void setExpertList(ArrayList<Expert> expertList) {
		this.expertList = expertList;
	}

	public boolean add(Expert e) {
		// TODO Auto-generated method stub
		try{
			expertDAO.save(e);
		}catch(Exception E){
			return false;
		}
		return true;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			expertDAO.delete(expertDAO.findById(id));
		}catch(Exception E){
			return false;
		}
		return true;
	}

	public ArrayList<Expert> searchAll() {
		// TODO Auto-generated method stub
		return expertList=(ArrayList<Expert>) expertDAO.findAll();
	}

	public ArrayList<Expert> search(String name) {
		// TODO Auto-generated method stub
		return expertList=(ArrayList<Expert>) expertDAO.findByName(name);
	}
	
	public boolean update(Expert e) {
		// TODO Auto-generated method stub
		try{
			expertDAO.update(e);
		}catch(Exception E){
			return false;
		}
		return true;
	}






}
