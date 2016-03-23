package service;

import java.util.ArrayList;

import entity.Question;

public interface QuestionService {
	public boolean add(Question q);
	public ArrayList<Question> searchAll();
	public ArrayList<Question> search(String coursename);
	public boolean update(Question q);

}
