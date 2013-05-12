package org.training.issuetracker.issues;

import java.util.Date;

import org.training.issuetracker.items.Item;

/**
 * @author Hanna Hulevich
 *
 */
public class Issue implements Item {
	private long id;
	private Date createDate;
	private long createdBy;
	private Date modifyDate;
	private long modifiedBy;
	private String summary;
	private String description;
	private String status;
	private String resolution;
	private String type;
	private String priority;
	private String project;
	private int buildFound;
	private long assignee;

	/**
	 *
	 */
	public Issue() {
		super();
	}

	/**
	 * @param id long
	 * @param createDate Date
	 * @param createdBy long
	 * @param modifyDate Date
	 * @param modifiedBy long
	 * @param summary String
	 * @param description String
	 * @param status String
	 * @param resolution String
	 * @param type String
	 * @param priority String
	 * @param project String
	 * @param buildFound String
	 * @param assignee long
	 */
	public Issue(long id, Date createDate, long createdBy, Date modifyDate,
			long modifiedBy, String summary, String description, String status,
			String resolution, String type, String priority, String project,
			int buildFound, long assignee) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.createdBy = createdBy;
		this.modifyDate = modifyDate;
		this.modifiedBy = modifiedBy;
		this.summary = summary;
		this.description = description;
		this.status = status;
		this.resolution = resolution;
		this.type = type;
		this.priority = priority;
		this.project = project;
		this.buildFound = buildFound;
		this.assignee = assignee;
	}

	/**
	 * @return long
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id long
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return Date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate Date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return long
	 */
	public long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy long
	 */
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return Date
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate Date
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return long
	 */
	public long getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy long
	 */
	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return String
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary String
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description String
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status String
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return String
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * @param resolution String
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	/**
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type String
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return String
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority String
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return String
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project String
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return int
	 */
	public int getBuildFound() {
		return buildFound;
	}

	/**
	 * @param buildFound int
	 */
	public void setBuildFound(int buildFound) {
		this.buildFound = buildFound;
	}

	/**
	 * @return long
	 */
	public long getAssignee() {
		return assignee;
	}

	/**
	 * @param assignee long
	 */
	public void setAssignee(long assignee) {
		this.assignee = assignee;
	}
}
