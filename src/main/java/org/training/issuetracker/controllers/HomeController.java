package org.training.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.issues.IssueFromList;
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
public class HomeController extends AbstractBaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 4183929286179831721L;

	/* (non-Javadoc)
	*@see org.training.issuetracker.controllers.AbstractBaseController#performTask(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String realPath = getRealPath();
		IssueDAO issueDAO = (IssueDAO) IssueDAOFactory
				.getDAO(Constants.ISSUE_DAO);
		UserDAO userDAO = (UserDAO) UserDAOFactory.getDAO(Constants.USER_DAO);
		ViewService viewService = new ViewService();
		List<IssueFromList> issues = viewService.getIssueList(issueDAO,
				userDAO, realPath);

		request.setAttribute(
				Constants.KEY_ISSUES_LIST,
				viewService.getSortedViewIssues(issues, Constants.NUMBER_ISSUES,
						request.getParameter(Constants.KEY_SORT)));
		jump(Constants.HOME_PAGE_URL, request, response);
	}
}
