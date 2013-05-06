package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controllers.AbstractBaseController;

public class LoginPage extends AbstractBaseController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		  out.println("<html>");
		  out.println("<head>");
		  out.println("<title>Login Page</title>");
		  out.println("</head>");
		  out.println("<body>");
		  out.println("<b>" + request.getAttribute("errorMessage") + "</b>");
		  out.println("<FORM method='POST' action='/issuetracker/login'>");
		  out.println("<div><lable>Email</lable><input type='text' name='email' value=''/>");
		  out.println("<div><lable>Password</lable><input type='text' name='password' value=''/>");
		  out.println("<button type='submit'>login</button>");
		  out.println("</body>");
		  out.println("</html>");
		  out.close();
	}
}
