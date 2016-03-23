package service;

import java.util.ArrayList;

import entity.Statute;

public interface StatuteService {
	public boolean add(Statute s);
	public boolean del(int id);
	public ArrayList<Statute> searchAll();
	public ArrayList<Statute> search(String name);
}
