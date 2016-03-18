package service;

import java.util.ArrayList;


import dao.UserDAO;
import entity.User;

public class UserServiceImpl implements UserService {

	UserDAO userDAO;
	private ArrayList<User> userList;
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			userDAO.delete(userDAO.findById(id));
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public boolean log(String name, String pwd) {
		// TODO Auto-generated method stub
		if (testLogName(name)) {
			userList=(ArrayList<User>)userDAO.findByName(name);
			if (pwd.equals(userList.get(0).getPwd())) {
				return true;//³É¹¦
			} 
		} 
		return false;
	}

	public boolean reg(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<User> search(String name) {
		// TODO Auto-generated method stub
		userList=(ArrayList<User>)userDAO.findByName(name);
		return userList;
	}

	public ArrayList<User> searchAll() {
		// TODO Auto-generated method stub
		userList=(ArrayList<User>)userDAO.findAll();
		return userList;
	}
	
	private  boolean testLogName(String name) {
		if (name == null || name.equals("")) {
			return false;
		}
		if (!userDAO.findByName(name).isEmpty()) {
			return true;
		}
		return false;
	}
	private boolean testRegName(String name) {
		if (name == null || name.equals("")) {
			return false;
		}
		if (!userDAO.findByName(name).isEmpty()) {
			return false;
		}
		return true;
	}
}
