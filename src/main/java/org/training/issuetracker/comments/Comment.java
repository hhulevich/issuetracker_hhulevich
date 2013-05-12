package org.training.issuetracker.comments;

import java.util.Date;

import org.training.issuetracker.items.Item;

/**
 * @author Hanna Hulevich
 *
 */
public class Comment implements Item {
	private long id;
	private long issueId;
	private long addedBy;
	private Date addDate;
	private String text;

	/**
	 *
	 */
	public Comment() {
		super();
	}

	/**
	 * @param id long
	 * @param issueId long
	 * @param addedBy long
	 * @param addDate Date
	 * @param text String
	 */
	public Comment(long id, long issueId, long addedBy, Date addDate,
			String text) {
		super();
		this.id = id;
		this.issueId = issueId;
		this.addedBy = addedBy;
		this.text = text;
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
	 * @return long
	 */
	public long getIssueId() {
		return issueId;
	}

	/**
	 * @param issueId long
	 */
	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	/**
	 * @return long
	 */
	public long getAddedBy() {
		return addedBy;
	}

	/**
	 * @param addedBy long
	 */
	public void setAddedBy(long addedBy) {
		this.addedBy = addedBy;
	}

	/**
	 * @return String
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return Date
	 */
	public Date getAddDate() {
		return addDate;
	}

	/**
	 * @param addDate Date
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	/**
	 * @param text String
	 */
	public void setText(String text) {
		this.text = text;
	}
}
