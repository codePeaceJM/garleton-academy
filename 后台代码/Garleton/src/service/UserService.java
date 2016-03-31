package service;

import java.util.ArrayList;

import entity.User;

public interface UserService {

	public boolean log(String name,String pwd);
	public boolean reg(User u);
	public ArrayList<User> search(String name);
	public ArrayList<User> searchAll();
	public boolean del(int id);
	public boolean update(User u);
}
