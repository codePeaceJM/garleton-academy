package entity;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String newsname;
	private String content;
	private String publisher;
	private String publishtime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(String newsname, String content, String publisher,
			String publishtime) {
		this.newsname = newsname;
		this.content = content;
		this.publisher = publisher;
		this.publishtime = publishtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNewsname() {
		return this.newsname;
	}

	public void setNewsname(String newsname) {
		this.newsname = newsname;
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

	public String getPublishtime() {
		return this.publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

}