package entity;

/**
 * Expert entity. @author MyEclipse Persistence Tools
 */

public class Expert implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String photo;
	private String description;
	private String achivements;
	private String remarks;
	private String type;
	private String strategy;
	private Boolean public_;

	// Constructors

	/** default constructor */
	public Expert() {
	}

	/** full constructor */
	public Expert(String name, String photo, String description,
			String achivements, String remarks, String type, String strategy,
			Boolean public_) {
		this.name = name;
		this.photo = photo;
		this.description = description;
		this.achivements = achivements;
		this.remarks = remarks;
		this.type = type;
		this.strategy = strategy;
		this.public_ = public_;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAchivements() {
		return this.achivements;
	}

	public void setAchivements(String achivements) {
		this.achivements = achivements;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStrategy() {
		return this.strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public Boolean getPublic_() {
		return this.public_;
	}

	public void setPublic_(Boolean public_) {
		this.public_ = public_;
	}

}