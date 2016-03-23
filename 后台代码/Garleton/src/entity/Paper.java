package entity;

/**
 * Paper entity. @author MyEclipse Persistence Tools
 */

public class Paper implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String type;
	private String coursename;
	private String content;
	private Integer score;
	private String student;
	private Boolean publish;

	// Constructors

	/** default constructor */
	public Paper() {
	}

	/** full constructor */
	public Paper(String title, String type, String coursename, String content,
			Integer score, String student, Boolean publish) {
		this.title = title;
		this.type = type;
		this.coursename = coursename;
		this.content = content;
		this.score = score;
		this.student = student;
		this.publish = publish;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getStudent() {
		return this.student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public Boolean getPublish() {
		return this.publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}

}