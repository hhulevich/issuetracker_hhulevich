package org.training.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.comments.CommentView;
import org.training.issuetracker.comments.factory.CommentDAO;
import org.training.issuetracker.comments.factory.CommentDAOFactory;
import org.training.issuetracker.issues.IssueView;
import org.training.issuetracker.issues.factory.IssueDAO;
import org.training.issuetracker.issues.factory.IssueDAOFactory;
import org.training.issuetracker.res.Constants;
import org.training.issuetracker.user.factory.UserDAO;
import org.training.issuetracker.user.factory.UserDAOFactory;
import org.training.issuetracker.view.ViewService;

/**
 * @author Hanna Hulevich
 *
 */
public class IssueController extends AbstractBaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 3097817337565596054L;

	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractBaseController#performTask(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String realPath = getRealPath();
		long issueId = Long.parseLong(request.getParameter(Constants.KEY_ID));
		IssueDAO issueDAO = (IssueDAO) IssueDAOFactory
				.getDAO(Constants.ISSUE_DAO);
		UserDAO userDAO = (UserDAO) UserDAOFactory.getDAO(Constants.USER_DAO);
		CommentDAO commentDAO = (CommentDAO) CommentDAOFactory
				.getDAO(Constants.COMMENT_DAO);
		ViewService viewService = new ViewService();
		List<CommentView> comments = viewService.getCommentsView(issueId,
				commentDAO, userDAO, realPath);
		IssueView issue = viewService.getIssueView(issueId, issueDAO, userDAO,
				realPath);
		request.setAttribute(Constants.KEY_COMMENTS_LIST, comments);
		request.setAttribute(Constants.KEY_ISSUE, issue);
		jump(Constants.ISSUE_PAGE_URL, request, response);
	}
}
