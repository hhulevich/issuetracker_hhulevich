package org.training.issuetracker.comments;

import java.io.Serializable;

public class CommentView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3698381336612003899L;
	private String text;
	private String addedBy;
	private String addDate;

	public CommentView() {
		super();
	}

	public CommentView(String text, String addedBy, String addDate) {
		super();
		this.text = text;
		this.addedBy = addedBy;
		this.addDate = addDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
}
