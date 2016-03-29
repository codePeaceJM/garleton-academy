package service;

import java.util.ArrayList;

import entity.Log;

public interface LogService {

	public boolean add(Log log);
	public ArrayList<Log> searchAll();
	public ArrayList<Log> searchByUid(Integer uid);
	public ArrayList<Log> searchByType(Integer type);
	public ArrayList<Log> searchByContent(String content);
	public ArrayList<Log> searchByTime(String begin,String end);
}
