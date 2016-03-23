package entity;

/**
 * Cases entity. @author MyEclipse Persistence Tools
 */

public class Cases implements java.io.Serializable {

	// Fields

	private Integer id;
	private String resourcename;
	private String resourcetype;
	private String resourcesource;
	private String description;
	private String occurplace;
	private String theinjuredname;
	private String enclosure;
	private String occurtime;
	private String occurdate;
	private Integer degree;
	private String copyrightholder;
	private Integer opendegree;
	private String laber;
	private String process;
	private String cause;
	private String handling;
	private String accountability;
	private String remedialmeasures;
	private String improvement;

	// Constructors

	/** default constructor */
	public Cases() {
	}

	/** full constructor */
	public Cases(String resourcename, String resourcetype,
			String resourcesource, String description, String occurplace,
			String theinjuredname, String enclosure, String occurtime,
			String occurdate, Integer degree, String copyrightholder,
			Integer opendegree, String laber, String process, String cause,
			String handling, String accountability, String remedialmeasures,
			String improvement) {
		this.resourcename = resourcename;
		this.resourcetype = resourcetype;
		this.resourcesource = resourcesource;
		this.description = description;
		this.occurplace = occurplace;
		this.theinjuredname = theinjuredname;
		this.enclosure = enclosure;
		this.occurtime = occurtime;
		this.occurdate = occurdate;
		this.degree = degree;
		this.copyrightholder = copyrightholder;
		this.opendegree = opendegree;
		this.laber = laber;
		this.process = process;
		this.cause = cause;
		this.handling = handling;
		this.accountability = accountability;
		this.remedialmeasures = remedialmeasures;
		this.improvement = improvement;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResourcename() {
		return this.resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getResourcetype() {
		return this.resourcetype;
	}

	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}

	public String getResourcesource() {
		return this.resourcesource;
	}

	public void setResourcesource(String resourcesource) {
		this.resourcesource = resourcesource;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOccurplace() {
		return this.occurplace;
	}

	public void setOccurplace(String occurplace) {
		this.occurplace = occurplace;
	}

	public String getTheinjuredname() {
		return this.theinjuredname;
	}

	public void setTheinjuredname(String theinjuredname) {
		this.theinjuredname = theinjuredname;
	}

	public String getEnclosure() {
		return this.enclosure;
	}

	public void setEnclosure(String enclosure) {
		this.enclosure = enclosure;
	}

	public String getOccurtime() {
		return this.occurtime;
	}

	public void setOccurtime(String occurtime) {
		this.occurtime = occurtime;
	}

	public String getOccurdate() {
		return this.occurdate;
	}

	public void setOccurdate(String occurdate) {
		this.occurdate = occurdate;
	}

	public Integer getDegree() {
		return this.degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public String getCopyrightholder() {
		return this.copyrightholder;
	}

	public void setCopyrightholder(String copyrightholder) {
		this.copyrightholder = copyrightholder;
	}

	public Integer getOpendegree() {
		return this.opendegree;
	}

	public void setOpendegree(Integer opendegree) {
		this.opendegree = opendegree;
	}

	public String getLaber() {
		return this.laber;
	}

	public void setLaber(String laber) {
		this.laber = laber;
	}

	public String getProcess() {
		return this.process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getCause() {
		return this.cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getHandling() {
		return this.handling;
	}

	public void setHandling(String handling) {
		this.handling = handling;
	}

	public String getAccountability() {
		return this.accountability;
	}

	public void setAccountability(String accountability) {
		this.accountability = accountability;
	}

	public String getRemedialmeasures() {
		return this.remedialmeasures;
	}

	public void setRemedialmeasures(String remedialmeasures) {
		this.remedialmeasures = remedialmeasures;
	}

	public String getImprovement() {
		return this.improvement;
	}

	public void setImprovement(String improvement) {
		this.improvement = improvement;
	}

}