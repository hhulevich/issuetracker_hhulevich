package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.issuetracker.res.Constants;
import org.training.issuetracker.user.User;
import org.training.issuetracker.user.factory.UserDAO;
import org.training.issuetracker.user.factory.UserDAOFactory;

/**
 * @author Hanna Hulevich
 *
 */
public class LoginController extends AbstractBaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractBaseController#performTask(javax.servlet.http.HttpServletRequest,
	 *  javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String email = request.getParameter(Constants.KEY_EMAIL);
		String password = request.getParameter(Constants.KEY_PASSWORD);

		if (email.isEmpty() || password.isEmpty()) {
			jumpError(Constants.LOGIN_PAGE_URL, Constants.MESSAGE_EMAIL_OR_PASSWORD_IS_EMPTY, request,
					response);
			return;
		}

		String realPath = getRealPath();
		UserDAO userDAO = (UserDAO) UserDAOFactory.getDAO(Constants.USER_DAO);
		User user = userDAO.getUser(email, password, realPath);
		if (user == null) {
			jumpError(Constants.LOGIN_PAGE_URL, Constants.MESSAGE_USER_NOT_EXIST, request, response);
		} else {
			session.setAttribute(Constants.KEY_USER, user);
			jump(Constants.HOME_CONTROLLER_URL, request, response);
		}
	}
}
