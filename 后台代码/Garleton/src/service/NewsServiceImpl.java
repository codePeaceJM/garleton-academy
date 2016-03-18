package service;

import java.util.ArrayList;

import dao.NewsDAO;

import entity.News;

public class NewsServiceImpl implements NewsService {
	ArrayList<News> newsList;
	private NewsDAO newsDAO;
	
	public ArrayList<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(ArrayList<News> newsList) {
		this.newsList = newsList;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	

	public boolean add(News n) {
		// TODO Auto-generated method stub
		try{
			newsDAO.save(n);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			newsDAO.delete(newsDAO.findById(id));
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public ArrayList<News> searchAll() {
		// TODO Auto-generated method stub
		return newsList=(ArrayList<News>) newsDAO.findAll();
	}

	public boolean update(News n) {
		// TODO Auto-generated method stub
		try{
			newsDAO.update(n);
		}catch(Exception e){
			return false;
		}
		return true;
	}

}
