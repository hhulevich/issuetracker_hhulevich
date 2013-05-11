package org.training.issuetracker.res;

import org.training.issuetracker.comments.factory.CommentDAO;
import org.training.issuetracker.issues.factory.IssueDAO;
import org.training.issuetracker.user.factory.UserDAO;

public interface Constants {

	String USERS_FILE_XML = "\\org\\training\\issuetracker\\res\\users.xml";
	String ISSUES_FILE_XML = "\\org\\training\\issuetracker\\res\\issues.xml";
	String COMMENTS_FILE_XML = "\\org\\training\\issuetracker\\res\\comments.xml";
	String USER_DAO = UserDAO.class.getName();
	String ISSUE_DAO = IssueDAO.class.getName();
	String COMMENT_DAO = CommentDAO.class.getName();
	String KEY_ERROR_MESSAGE = "errorMessage";
}
