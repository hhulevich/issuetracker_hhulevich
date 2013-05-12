package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.issuetracker.controllers.AbstractBaseController;
import org.training.issuetracker.res.Constants;
import org.training.issuetracker.user.User;

/**
 * @author Hanna Hulevich
 *
 */
public class Header extends AbstractBaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractBaseController#performTask(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Constants.KEY_USER);
		PrintWriter out = response.getWriter();
		out.println("<div style='background-color: #D4F6FA;'>");
		out.println("<a href='/issuetracker/homeController'>Home </a>");
		if (user != null) {
			out.println("<a href='/issuetracker/logoutController'>Logout</a>");
			out.println("<b> welcom " + user.getFirstName() + " "
					+ user.getLastName() + "</b>");
		} else {
			out.println("<a href='/issuetracker/loginPage'>Login</a>");
			out.println("Please login");
		}
		out.println("</div>");
	}

}
