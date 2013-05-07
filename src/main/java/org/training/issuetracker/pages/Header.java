package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.issuetracker.controllers.AbstractBaseController;
import org.training.issuetracker.user.User;

public class Header extends AbstractBaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<div style='position:absolute; top:5px;'>");
		out.println("<a href='/issuetracker/loginPage'>Login</a>");
		out.println("<a href='/issuetracker/homePage'>Home </a>");
		if (user != null) {
			out.println("<b> welcom " + user.getFirstName() + " "
					+ user.getLastName() + "</b");
		}
		out.println("</div>");
		out.println("</html>");
	}

}
