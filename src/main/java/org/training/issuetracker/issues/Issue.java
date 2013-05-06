package org.training.issuetracker.issues;

import java.util.Date;

public class Issue {
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
	private int priority;
	private String project;
	private int build_found;
	private long assignee;
	
	public Issue() {
		super();
	}

	public Issue(long id, Date createDate, long createdBy, Date modifyDate,
			long modifiedBy, String summary, String description, String status,
			String resolution, String type, int priority, String project,
			int build_found, long assignee) {
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
		this.build_found = build_found;
		this.assignee = assignee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getBuild_found() {
		return build_found;
	}

	public void setBuild_found(int build_found) {
		this.build_found = build_found;
	}

	public long getAssignee() {
		return assignee;
	}

	public void setAssignee(long assignee) {
		this.assignee = assignee;
	}
}
