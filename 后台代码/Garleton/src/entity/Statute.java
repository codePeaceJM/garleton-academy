package entity;

/**
 * Statute entity. @author MyEclipse Persistence Tools
 */

public class Statute implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String statement;
	private String type;
	private String source;
	private Boolean top;
	private Boolean upload;
	private String pdf;
	private String remarks;

	// Constructors

	/** default constructor */
	public Statute() {
	}

	/** full constructor */
	public Statute(String name, String statement, String type, String source,
			Boolean top, Boolean upload, String pdf, String remarks) {
		this.name = name;
		this.statement = statement;
		this.type = type;
		this.source = source;
		this.top = top;
		this.upload = upload;
		this.pdf = pdf;
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

	public String getStatement() {
		return this.statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Boolean getTop() {
		return this.top;
	}

	public void setTop(Boolean top) {
		this.top = top;
	}

	public Boolean getUpload() {
		return this.upload;
	}

	public void setUpload(Boolean upload) {
		this.upload = upload;
	}

	public String getPdf() {
		return this.pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}