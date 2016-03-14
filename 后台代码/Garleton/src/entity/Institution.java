package entity;

/**
 * Institution entity. @author MyEclipse Persistence Tools
 */

public class Institution implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String type;
	private String superior;
	private Integer did;
	private String level;
	private String pic;
	private String address;
	private Integer postcode;
	private Integer tel;
	private Integer fax;
	private String email;
	private String comment;

	// Constructors

	/** default constructor */
	public Institution() {
	}

	/** minimal constructor */
	public Institution(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Institution(Integer id, String name, String type, String superior,
			Integer did, String level, String pic, String address,
			Integer postcode, Integer tel, Integer fax, String email,
			String comment) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.superior = superior;
		this.did = did;
		this.level = level;
		this.pic = pic;
		this.address = address;
		this.postcode = postcode;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
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

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPostcode() {
		return this.postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public Integer getTel() {
		return this.tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public Integer getFax() {
		return this.fax;
	}

	public void setFax(Integer fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}