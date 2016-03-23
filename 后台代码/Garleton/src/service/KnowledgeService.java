package service;

import java.util.ArrayList;

import entity.Knowledge;

public interface KnowledgeService {
	public boolean add(Knowledge k);
	public boolean del(int id);
	public ArrayList<Knowledge> searchAll();
	public ArrayList<Knowledge> search(String name);

}
