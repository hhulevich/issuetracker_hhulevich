package org.training.issuetracker.user;

import org.training.issuetracker.items.Item;

/**
 * @author Hanna Hulevich
 *
 */
public class User implements Item {

	private long id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String role;
	private String password;

	/**
	 *
	 */
	public User() {
		super();
	}

	/**
	 * @param id long
	 * @param firstName String
	 * @param lastName String
	 * @param emailAddress String
	 * @param role String
	 * @param password String
	 */
	public User(long id, String firstName, String lastName,
			String emailAddress, String role, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.role = role;
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.items.Item#getId()
	 */
	@Override
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
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName String
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return String
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress String
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return String
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role String
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password String
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
