package org.training.issuetracker.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.issuetracker.issues.IssueFromList;
import org.training.issuetracker.issues.factory.IssueDAO;
import org.training.issuetracker.issues.factory.IssueDAOFactory;
import org.training.issuetracker.res.Constants;
import org.training.issuetracker.user.factory.UserDAO;
import org.training.issuetracker.user.factory.UserDAOFactory;
import org.training.issuetracker.view.ViewService;

public class HomeController extends AbstractBaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4183929286179831721L;

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String realPath = getRealPath();
		IssueDAO issueDAO = (IssueDAO) IssueDAOFactory
				.getDAO(Constants.ISSUE_DAO);
		UserDAO userDAO = (UserDAO) UserDAOFactory
				.getDAO(Constants.USER_DAO);
		ViewService viewService = new ViewService();
		List<IssueFromList> issues = viewService.getIssueList(issueDAO, userDAO, realPath);
		
		session.setAttribute("issues", viewService.getSortedViewIssues(issues, 10, request.getParameter("sort")));
		jump("/homePage", request, response);
	}
}
