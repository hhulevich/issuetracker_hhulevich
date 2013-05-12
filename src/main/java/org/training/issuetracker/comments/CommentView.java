package org.training.issuetracker.comments;

import java.io.Serializable;

/**
 * @author Hanna Hulevich
 *
 */
public class CommentView implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3698381336612003899L;
	private String text;
	private String addedBy;
	private String addDate;

	/**
	 *
	 */
	public CommentView() {
		super();
	}

	/**
	 * @param text String
	 * @param addedBy String
	 * @param addDate String
	 */
	public CommentView(String text, String addedBy, String addDate) {
		super();
		this.text = text;
		this.addedBy = addedBy;
		this.addDate = addDate;
	}

	/**
	 * @return String
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text String
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return String
	 */
	public String getAddedBy() {
		return addedBy;
	}

	/**
	 * @param addedBy String
	 */
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	/**
	 * @return String
	 */
	public String getAddDate() {
		return addDate;
	}

	/**
	 * @param addDate String
	 */
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
}
