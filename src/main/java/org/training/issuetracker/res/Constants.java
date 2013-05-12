package org.training.issuetracker.res;

import org.training.issuetracker.comments.factory.CommentDAO;
import org.training.issuetracker.issues.factory.IssueDAO;
import org.training.issuetracker.user.factory.UserDAO;

/**
 * @author Hanna Hulevich
 *
 */
public final class Constants {

	/**
	 *
	 */
	public static final String USERS_FILE_XML = "\\org\\training\\issuetracker\\res\\users.xml";
	/**
	 *
	 */
	public static final String ISSUES_FILE_XML = "\\org\\training\\issuetracker\\res\\issues.xml";
	/**
	 *
	 */
	public static final String COMMENTS_FILE_XML = "\\org\\training\\issuetracker\\res\\comments.xml";
	/**
	 *
	 */
	public static final String USER_DAO = UserDAO.class.getName();
	/**
	 *
	 */
	public static final String ISSUE_DAO = IssueDAO.class.getName();
	/**
	 *
	 */
	public static final String COMMENT_DAO = CommentDAO.class.getName();
	/**
	 *
	 */
	public static final String KEY_ERROR_MESSAGE = "errorMessage";
	/**
	 *
	 */
	public static final int NUMBER_ISSUES = 10;

	/**
	 *
	 */
	public static final String KEY_ISSUES_LIST = "issues";

	/**
	 *
	 */
	public static final String KEY_ISSUE = "issue";
	/**
	 *
	 */
	public static final String KEY_SORT = "sort";

	/**
	 *
	 */
	public static final String KEY_ID = "id";

	/**
	 *
	 */
	public static final String KEY_EMAIL = "email";

	/**
	 *
	 */
	public static final String KEY_USER = "user";
	/**
	 *
	 */
	public static final String KEY_PASSWORD = "password";
	/**
	 *
	 */
	public static final String KEY_COMMENTS_LIST = "comments";

	/**
	 *
	 */
	public static final String MESSAGE_EMAIL_OR_PASSWORD_IS_EMPTY = "Email or password is empty";

	/**
	 *
	 */
	public static final String MESSAGE_USER_NOT_EXIST = "User not exist";

	/**
	 *
	 */
	public static final String HOME_PAGE_URL = "/homePage";

	/**
	 *
	 */
	public static final String ISSUE_PAGE_URL = "/issuePage";

	/**
	 *
	 */
	public static final String LOGIN_PAGE_URL = "/loginPage";

	/**
	 *
	 */
	public static final String HOME_CONTROLLER_URL = "/homeController";

	/**
	 *
	 */
	public static final String HEADER_URL = "/header";

	/**
	 *
	 */
	public static final String FOOTER_URL = "/footer";

	/**
	 *
	 */
	private Constants() {
		super();
	}

}
