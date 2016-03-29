package service;

import java.util.ArrayList;

import dao.LogDAO;

import entity.Log;

public class LogServiceImpl implements LogService {
	LogDAO logDAO;

	public LogDAO getLogDAO() {
		return logDAO;
	}

	public void setLogDAO(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	public boolean add(Log log) {
		// TODO Auto-generated method stub
		try{
			logDAO.save(log);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public ArrayList<Log> searchAll() {
		// TODO Auto-generated method stub
		return (ArrayList<Log>)logDAO.findAll();
	}

	public ArrayList<Log> searchByContent(String content) {
		// TODO Auto-generated method stub
		return (ArrayList<Log>)logDAO.findByContent(content);
	}

	public ArrayList<Log> searchByTime(String begin, String end) {
		// TODO Auto-generated method stub
		return (ArrayList<Log>)logDAO.findByTime(begin, end);
	}

	public ArrayList<Log> searchByType(Integer type) {
		// TODO Auto-generated method stub
		return (ArrayList<Log>)logDAO.findByType(type);
	}

	public ArrayList<Log> searchByUid(Integer uid) {
		// TODO Auto-generated method stub
		return (ArrayList<Log>)logDAO.findByUid(uid);
	}

}
