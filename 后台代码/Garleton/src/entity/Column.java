package entity;

/**
 * Column entity. @author MyEclipse Persistence Tools
 */

public class Column implements java.io.Serializable {

	// Fields

	private Integer id;
	private String institute;
	private String name;
	private String icon;
	private String description;
	private String keyword;
	private String publisher;
	private String publishtime;

	// Constructors

	/** default constructor */
	public Column() {
	}

	/** full constructor */
	public Column(String institute, String name, String icon,
			String description, String keyword, String publisher,
			String publishtime) {
		this.institute = institute;
		this.name = name;
		this.icon = icon;
		this.description = description;
		this.keyword = keyword;
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

	public String getInstitute() {
		return this.institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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