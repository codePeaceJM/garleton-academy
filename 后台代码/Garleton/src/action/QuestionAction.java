package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import service.QuestionService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Question;

public class QuestionAction extends ActionSupport implements ModelDriven<Question>{
	private Question question = new Question();
	QuestionService questionService;
	ArrayList<Question> questionList;

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
			return "add_question_success";
		}else{
			return "add_question_fail";
		}
		
	}
	public String update(){
		if(questionService.update(question)){
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

}
