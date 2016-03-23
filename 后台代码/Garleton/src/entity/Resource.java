package entity;

/**
 * Resource entity. @author MyEclipse Persistence Tools
 */

public class Resource implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String type;
	private Integer hotdegree;
	private String file;
	private String source;
	private String statement;
	private String comment;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** minimal constructor */
	public Resource(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Resource(Integer id, String name, String type, Integer hotdegree,
			String file, String source, String statement, String comment) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.hotdegree = hotdegree;
		this.file = file;
		this.source = source;
		this.statement = statement;
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

	public Integer getHotdegree() {
		return this.hotdegree;
	}

	public void setHotdegree(Integer hotdegree) {
		this.hotdegree = hotdegree;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatement() {
		return this.statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}