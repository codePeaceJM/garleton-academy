package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import service.LogService;
import service.QuestionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Question;

public class QuestionAction extends ActionSupport implements SessionAware,ModelDriven<Question>{
	private Question question = new Question();
	QuestionService questionService;
	ArrayList<Question> questionList;
	private Map<String, Object> session;
	LogService logService;

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public ArrayList<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(ArrayList<Question> questionList) {
		this.questionList = questionList;
	}
	
	public String add(){
		if(questionService.add(question)){
			logService.add((Integer) session.get("id"), 1, "question");
			return "add_question_success";
		}else{
			return "add_question_fail";
		}
		
	}
	public String update(){
		if(questionService.update(question)){
			logService.add((Integer) session.get("id"), 3, "question");
			return "update_question_success";
		}else{
			return "update_question_fail";
		}		
	}
	public String search(){
		if("".equals(question.getCoursename())||question.getCoursename()==null){
			questionList=questionService.searchAll();			
		}else{
			questionList=questionService.search(question.getCoursename());
		}
		if(questionList.isEmpty()){
			return "search_question_fail";
		}else{
			JSONArray jsonArray =  JSONArray.fromObject(questionList);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
			response.setCharacterEncoding("UTF-8"); 
			try {
				response.getWriter().print(jsonArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "search_question_success";
		}
		
	}

	public Question getModel() {
		// TODO Auto-generated method stub
		return question;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
