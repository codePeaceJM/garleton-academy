package entity;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String type;
	private String image;
	private String enclosure;
	private String openCharacter;
	private String description;
	private String remarks;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String name, String type, String image, String enclosure,
			String openCharacter, String description, String remarks) {
		this.name = name;
		this.type = type;
		this.image = image;
		this.enclosure = enclosure;
		this.openCharacter = openCharacter;
		this.description = description;
		this.remarks = remarks;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEnclosure() {
		return this.enclosure;
	}

	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}

	public String getOpenCharacter() {
		return this.openCharacter;
	}

	public void setOpenCharacter(String openCharacter) {
		this.openCharacter = openCharacter;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}