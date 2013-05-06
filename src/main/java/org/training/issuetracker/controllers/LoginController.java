package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.issuetracker.user.User;
import org.training.issuetracker.user.factory.UserDAO;
import org.training.issuetracker.user.factory.UserDAOFactory;

public class LoginController extends AbstractBaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email.isEmpty() || password.isEmpty()) {
			jumpError("/loginPage", "Email or password is empty", request, response);
			return;
		}
		
		String realPath = getServletConfig().getServletContext().getRealPath(
				"/")
				+ "WEB-INF\\classes\\";
		UserDAO userDAO = (UserDAO) UserDAOFactory
				.getDAO("org.training.issuetracker.user.factory.UserDAO");
		User user = userDAO.getUser(email, password, realPath);
		if (user == null) {
			jumpError("/loginPage", "User not exist", request, response);
		} else {
			session.setAttribute("user", user);
			jump("/sample", request, response);
		}
	}
}
