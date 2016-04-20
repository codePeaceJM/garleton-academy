package service;

import java.util.ArrayList;

import dao.PaperDAO;

import entity.Paper;

public class PaperServiceImpl implements PaperService {
	PaperDAO paperDAO;
	ArrayList<Paper> paperList;

	public PaperDAO getPaperDAO() {
		return paperDAO;
	}

	public void setPaperDAO(PaperDAO paperDAO) {
		this.paperDAO = paperDAO;
	}

	public ArrayList<Paper> getPaperList() {
		return paperList;
	}

	public void setPaperList(ArrayList<Paper> paperList) {
		this.paperList = paperList;
	}

	public boolean add(Paper p) {
		// TODO Auto-generated method stub
		try{
			paperDAO.save(p);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			paperDAO.delete(paperDAO.findById(id));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	

	public ArrayList<Paper> searchAll() {
		// TODO Auto-generated method stub
		return paperList=(ArrayList<Paper>) paperDAO.findAll();
	}
	public ArrayList<Paper> searchByCourseName(String coursename) {
		// TODO Auto-generated method stub
		return paperList=(ArrayList<Paper>) paperDAO.findByCoursename(coursename);
	}

	public ArrayList<Paper> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return paperList=(ArrayList<Paper>) paperDAO.findByTitle(title);
	}

	public ArrayList<Paper> searchByType(String type) {
		// TODO Auto-generated method stub
		return paperList=(ArrayList<Paper>) paperDAO.findByType(type);
	}


	public boolean update(Paper p) {
		// TODO Auto-generated method stub
		try{
			paperDAO.update(p);
		}catch(Exception e){
			return false;
		}
		return true;
	}


}
