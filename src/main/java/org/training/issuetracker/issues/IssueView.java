package org.training.issuetracker.issues;

import java.io.Serializable;

/**
 * @author Hanna Hulevich
 *
 */
public class IssueView implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String createDate;
	private String createdBy;
	private String modifyDate;
	private String modifiedBy;
	private String summary;
	private String description;
	private String status;
	private String resolution;
	private String type;
	private String priority;
	private String project;
	private int buildFound;
	private String assignee;

	/**
	 *
	 */
	public IssueView() {
		super();
	}

	/**
	 * @param id long
	 * @param createDate String
	 * @param createdBy String
	 * @param modifyDate String
	 * @param modifiedBy String
	 * @param summary String
	 * @param description String
	 * @param status String
	 * @param resolution String
	 * @param type String
	 * @param priority String
	 * @param project String
	 * @param buildFound int
	 * @param assignee String
	 */
	public IssueView(long id, String createDate, String createdBy,
			String modifyDate, String modifiedBy, String summary,
			String description, String status, String resolution, String type,
			String priority, String project, int buildFound, String assignee) {
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
	 * @return String
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate String
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return String
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy String
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return String
	 */
	public String getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate String
	 */
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return String
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy String
	 */
	public void setModifiedBy(String modifiedBy) {
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
	 * @return String
	 */
	public String getAssignee() {
		return assignee;
	}

	/**
	 * @param assignee String
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
}
