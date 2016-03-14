package entity;

/**
 * District entity. @author MyEclipse Persistence Tools
 */

public class District implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String type;
	private String superior;
	private String comment;

	// Constructors

	/** default constructor */
	public District() {
	}

	/** minimal constructor */
	public District(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public District(Integer id, String name, String type, String superior,
			String comment) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.superior = superior;
		this.comment = comment;
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

	public String getSuperior() {
		return this.superior;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}