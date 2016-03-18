package entity;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer id;
	private String newstype;
	private String columnName;
	private String title;
	private String contentAbout;
	private String content;
	private String publisher;
	private String publishTime;
	private String picture;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(String newstype, String columnName, String title,
			String contentAbout, String content, String publisher,
			String publishTime, String picture) {
		this.newstype = newstype;
		this.columnName = columnName;
		this.title = title;
		this.contentAbout = contentAbout;
		this.content = content;
		this.publisher = publisher;
		this.publishTime = publishTime;
		this.picture = picture;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNewstype() {
		return this.newstype;
	}

	public void setNewstype(String newstype) {
		this.newstype = newstype;
	}

	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContentAbout() {
		return this.contentAbout;
	}

	public void setContentAbout(String contentAbout) {
		this.contentAbout = contentAbout;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}