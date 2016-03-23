package service;

import java.util.ArrayList;

import entity.Course;

public interface CourseService {
	public boolean add(Course c);
	public boolean del(int id);
	public boolean update(Course c);
	public ArrayList<Course> searchAll();
	public ArrayList<Course> search(String name);

}
