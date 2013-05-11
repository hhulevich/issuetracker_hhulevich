package org.training.issuetracker.comments;

import java.util.Date;

import org.training.issuetracker.items.Item;

public class Comment implements Item {

	private long id;
	private long issueId;
	private long addedBy;
	private Date addDate;
	private String text;

	public Comment() {
		super();
	}

	public Comment(long id, long issueId, long addedBy, Date addDate,
			String text) {
		super();
		this.id = id;
		this.issueId = issueId;
		this.addedBy = addedBy;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public long getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(long addedBy) {
		this.addedBy = addedBy;
	}

	public String getText() {
		return text;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setText(String text) {
		this.text = text;
	}
}
