package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controllers.AbstractBaseController;

public class LoginPage extends AbstractBaseController {

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

		
		out.println("<div style='position:absolute; top:40px'>");
		Object errorMessage = request.getAttribute("errorMessage");
		if (errorMessage != null) {
			out.println("<b>" + request.getAttribute("errorMessage") + "</b>");
		}
		out.println("<form method='POST' action='/issuetracker/login'>");
		out.println("<table>");
		out.println("</tbody>");
		out.println("<tr>");
		out.println("<td><lable>Email</lable></td>");
		out.println("<td><input type='text' name='email' value=''/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><lable>Password</lable></td>");
		out.println("<td><input type='text' name='password' value=''/></td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("<button type='submit'>login</button>");
		out.println("</form>");
		out.println("</div>");
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/header");
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
