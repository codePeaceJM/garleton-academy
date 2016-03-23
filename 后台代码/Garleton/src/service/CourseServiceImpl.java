package service;

import java.util.ArrayList;

import dao.CourseDAO;

import entity.Course;

public class CourseServiceImpl implements CourseService {
	CourseDAO courseDAO;
	ArrayList<Course> courseList;

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	public boolean add(Course c) {
		// TODO Auto-generated method stub
		try{
			courseDAO.save(c);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public boolean del(int id) {
		// TODO Auto-generated method stub
		try{
			courseDAO.delete(courseDAO.findById(id));
		}catch(Exception e){
			return false;
	
		}
		return true;
	}

	public boolean update(Course c) {
		// TODO Auto-generated method stub
		try{
			courseDAO.update(c);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public ArrayList<Course> searchAll() {
		// TODO Auto-generated method stub
		return courseList=(ArrayList<Course>) courseDAO.findAll();
	}	

	public ArrayList<Course> search(String name) {
		// TODO Auto-generated method stub
		return courseList=(ArrayList<Course>) courseDAO.findByName(name);
	}

}
