package entity;

/**
 * Knowledge entity. @author MyEclipse Persistence Tools
 */

public class Knowledge implements java.io.Serializable {

	// Fields

	private Integer id;
	private String coverimage;
	private String name;
	private String classification;
	private String type;
	private String content;
	private String remarks;

	// Constructors

	/** default constructor */
	public Knowledge() {
	}

	/** full constructor */
	public Knowledge(String coverimage, String name, String classification,
			String type, String content, String remarks) {
		this.coverimage = coverimage;
		this.name = name;
		this.classification = classification;
		this.type = type;
		this.content = content;
		this.remarks = remarks;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCoverimage() {
		return this.coverimage;
	}

	public void setCoverimage(String coverimage) {
		this.coverimage = coverimage;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}