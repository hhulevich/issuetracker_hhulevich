package org.training.issuetracker.issues;

import java.io.Serializable;

/**
 * @author Hanna Hulevich
 *
 */
public class IssueFromList implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String priority;
	private String assignee;
	private String type;
	private String status;
	private String summary;

	/**
	 *
	 */
	public IssueFromList() {
		super();
	}

	/**
	 * @param id long
	 * @param priority String
	 * @param assignee String
	 * @param type String
	 * @param status String
	 * @param summary String
	 */
	public IssueFromList(long id, String priority, String assignee,
			String type, String status, String summary) {
		super();
		this.id = id;
		this.priority = priority;
		this.assignee = assignee;
		this.type = type;
		this.status = status;
		this.summary = summary;
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
	public String getAssignee() {
		return assignee;
	}

	/**
	 * @param assignee String
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
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
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary String
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
