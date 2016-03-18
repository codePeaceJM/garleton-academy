package action;

import java.util.ArrayList;

import service.NewsService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.News;

public class NewsAction extends ActionSupport implements ModelDriven<News>{
	
	NewsService newsService;
	ArrayList<News> newsList;
	private News news = new News();
	
	public String add(){
		if(newsService.add(news)){
			return "add_news_success";
		}else{
			return "add_news_fail";
		}
	}
	public String del(){
		if(newsService.del(news.getId())){
			return "del_news_success";			
		}else{
			return "del_news_fail";
		}
		
	}
	public String update(){
		if(newsService.update(news)){
			return "update_news_success";
		}else{
			return "update_news_fail";
		}
		
	}
	public String searchAll(){
		newsList = newsService.searchAll();
		return "searchAll_news_success";
		
	}
	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public ArrayList<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(ArrayList<News> newsList) {
		this.newsList = newsList;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	

	public News getModel() {
		// TODO Auto-generated method stub
		return news;
	}

}
