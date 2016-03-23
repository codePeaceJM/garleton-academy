package service;

import java.util.ArrayList;

import dao.StatuteDAO;

import entity.Statute;

public class StatuteServiceImpl implements StatuteService {
	StatuteDAO statuteDAO;
	ArrayList<Statute> statuteList;

	public StatuteDAO getStatuteDAO() {
		return statuteDAO;
	}

	public void setStatuteDAO(StatuteDAO statuteDAO) {
		this.statuteDAO = statuteDAO;
	}

	public ArrayList<Statute> getStatuteList() {
		return statuteList;
	}

	public void setStatuteList(ArrayList<Statute> statuteList) {
		this.statuteList = statuteList;
	}

	public boolean add(Statute s) {
		// TODO Auto-generated method stub
		try{
			statuteDAO.save(s);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			statuteDAO.delete(statuteDAO.findById(id));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public ArrayList<Statute> searchAll() {
		// TODO Auto-generated method stub
		return statuteList=(ArrayList<Statute>) statuteDAO.findAll();
	}

	public ArrayList<Statute> search(String name) {
		// TODO Auto-generated method stub
		return statuteList=(ArrayList<Statute>) statuteDAO.findByName(name);
	}

}
