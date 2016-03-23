package service;

import java.util.ArrayList;

import dao.QuestionDAO;

import entity.Question;

public class QuestionServiceImpl implements QuestionService {
	QuestionDAO questionDAO;
	ArrayList<Question> questionList;

	public QuestionDAO getQuestionDAO() {
		return questionDAO;
	}

	public void setQuestionDAO(QuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}

	public boolean add(Question q) {
		// TODO Auto-generated method stub
		try{
			questionDAO.save(q);
		}catch(Exception e){
			return false;
	
		}
		return true;
		
	}

	public ArrayList<Question> searchAll() {
		// TODO Auto-generated method stub
		return questionList=(ArrayList<Question>) questionDAO.findAll();
	}
	
	public ArrayList<Question> search(String coursename) {
		// TODO Auto-generated method stub
		return questionList=(ArrayList<Question>) questionDAO.findByCoursename(coursename);
	}

	public boolean update(Question q) {
		// TODO Auto-generated method stub
		try{
			questionDAO.update(q);
		}catch(Exception e){
			return false;
	
		}
		return true;
		
	}


}
