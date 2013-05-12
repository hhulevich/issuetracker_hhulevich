package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hanna Hulevich
 *
 */
public class LoginPage extends AbstractPage {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public LoginPage() {
		super();
		setTittle("Login Page");
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.pages.AbstractPage#printPageContent(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void printPageContent(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<form method='POST' action='/issuetracker/login'>");
		out.println("<table>");
		out.println("</tbody>");
		out.println("<tr>");
		out.println("<td><lable>Email</lable></td>");
		out.println("<td><input type='text' name='email' value=''/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><lable>Password</lable></td>");
		out.println("<td><input type='password' name='password' value=''/></td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("<button type='submit'>login</button>");
		out.println("</form>");
	}
}
