package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import service.CourseService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Course;

public class CourseAction extends ActionSupport implements ModelDriven<Course>{
	private Course course = new Course();
	CourseService courseService;
	ArrayList<Course> courseList;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
	
	public String add(){
		if(courseService.add(course)){
			return "add_course_success";
			
		}else{
			return "add_course_fail";
		}
		
	}
	
	public String del(){
		if(courseService.del(course.getId())){
			return "del_course_success";
			
		}else{
			return "del_course_fail";
		}
	}
	
	public String update(){
		if(courseService.update(course)){
			return "update_course_success";
			
		}else{
			return "update_course_fail";
		}
	}
	
	public String search(){
		if("".equals(course.getName())||course.getName()==null){
			courseList=courseService.searchAll();
			
		}else{
			courseList=courseService.search(course.getName());
		}
		if(courseList.isEmpty()){
			return "search_course_fail";
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(courseList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_course_success";
		}
		
	}

	public Course getModel() {
		// TODO Auto-generated method stub
		return course;
	}

}
