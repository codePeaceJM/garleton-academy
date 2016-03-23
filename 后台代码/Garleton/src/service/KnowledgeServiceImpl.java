package service;

import java.util.ArrayList;

import dao.KnowledgeDAO;

import entity.Knowledge;

public class KnowledgeServiceImpl implements KnowledgeService{
	KnowledgeDAO knowledgeDAO;
	ArrayList<Knowledge> knowledgeList;

	public KnowledgeDAO getKnowledgeDAO() {
		return knowledgeDAO;
	}

	public void setKnowledgeDAO(KnowledgeDAO knowledgeDAO) {
		this.knowledgeDAO = knowledgeDAO;
	}

	public ArrayList<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}

	public void setKnowledgeList(ArrayList<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}

	public boolean add(Knowledge k) {
		// TODO Auto-generated method stub
		try{
			knowledgeDAO.save(k);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			knowledgeDAO.delete(knowledgeDAO.findById(id));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public ArrayList<Knowledge> searchAll() {
		// TODO Auto-generated method stub
		return knowledgeList=(ArrayList<Knowledge>) knowledgeDAO.findAll();
	}

	public ArrayList<Knowledge> search(String name) {
		// TODO Auto-generated method stub
		return knowledgeList=(ArrayList<Knowledge>) knowledgeDAO.findByName(name);
	}

}
