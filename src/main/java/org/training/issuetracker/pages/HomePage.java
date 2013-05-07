package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controllers.AbstractBaseController;
import org.training.issuetracker.issues.Issue;
import org.training.issuetracker.issues.factory.IssueDAO;
import org.training.issuetracker.issues.factory.IssueDAOFactory;
import org.training.issuetracker.user.User;
import org.training.issuetracker.user.factory.UserDAO;
import org.training.issuetracker.user.factory.UserDAOFactory;

public class HomePage extends AbstractBaseController {

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
		out.println("<title>Home Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div style='position:absolute; top:40px'>");
		Object errorMessage = request.getAttribute("errorMessage");
		if (errorMessage != null) {
			out.println("<b>" + request.getAttribute("errorMessage") + "</b>");
		}
		String realPath = getServletConfig().getServletContext().getRealPath(
				"/")
				+ "WEB-INF\\classes\\";
		IssueDAO issueDAO = (IssueDAO) IssueDAOFactory
				.getDAO("org.training.issuetracker.issues.factory.IssueDAO");
		List<Issue> issues = issueDAO.getIssues(realPath);
		if (issues.isEmpty()) {
			out.println("There is no issues to display");
		} else {
			UserDAO userDAO = (UserDAO) UserDAOFactory
					.getDAO("org.training.issuetracker.user.factory.UserDAO");
			out.println("<h2>Issues</h2>");
			out.println("<table border='1'>");
			out.println("<thead>");
			out.println("<tr><td>Id</td><td>Priority</td>" +
					"<td>Assignee</td><td>Type</td><td>Status</td><td>Summary</td>");
			out.println("</thead>");
			
			out.println("<tbody>");
			int i=0;
			for (Issue issue : issues) {
				out.println("<tr>");
				out.println("<td>" + issue.getId() + "</td>");
				out.println("<td>" + issue.getPriority() + "</td>");
				User user = userDAO.getUserById(issue.getAssignee(), realPath);
				out.println("<td>");
					if (user != null) {
						out.println(user.getLastName());
					} else {
						out.println("not assigned");
					}
					out.println("</td>");
				out.println("<td>" + issue.getType() + "</td>");
				out.println("<td>" + issue.getStatus() + "</td>");
				out.println("<td>" + issue.getSummary() + "</td>");
				out.println("</tr>");
				i++;
				if (i==10) {
					return;
				}
			}
				
		}
			out.println("</tbody>");
			out.println("</table>");
			out.println("</div>");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/header");
			rd.include(request, response);
			out.println("</body>");
			out.println("</html>");
			out.close();
		
		}
	}
