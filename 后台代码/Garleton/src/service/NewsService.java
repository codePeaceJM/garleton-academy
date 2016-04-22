package service;

import java.util.ArrayList;

import entity.News;

public interface NewsService {
	public boolean add(News n);
	public boolean del(int id);
	public boolean update(News n);
	public ArrayList<News> searchAll();
	public ArrayList<News> searchByTitle(String title);
	public ArrayList<News> searchNotice();
	public ArrayList<News> searchArticle();
	public ArrayList<News> searchPicture();
}
