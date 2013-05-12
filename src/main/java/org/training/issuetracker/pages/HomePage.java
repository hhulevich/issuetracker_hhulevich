package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.issues.IssueFromList;
import org.training.issuetracker.res.Constants;

/**
 * @author Hanna Hulevich
 *
 */
public class HomePage extends AbstractPage {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public HomePage() {
		super();
		setTittle("Home Page");
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.pages.AbstractPage#printPageContent(javax.servlet.http.HttpServletRequest,
	 *javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void printPageContent(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		@SuppressWarnings("unchecked")
		List<IssueFromList> issues = (List<IssueFromList>) request
				.getAttribute(Constants.KEY_ISSUES_LIST);
		PrintWriter out = response.getWriter();
		if (issues.isEmpty()) {
			out.println("There is no issues to display");
		} else {
			out.println("<h2>Issues</h2>");
			out.println("<table border='1'>");
			out.println("<thead>");
			out.println("<tr><td>Id <a href=/issuetracker/homeController?sort=id_desc> >"
					+ "</a><a href=/issuetracker/homeController?sort=id_asc> < </a></td>"
					+ "<td>Priority <a href=/issuetracker/homeController?sort=priority_desc> >"
					+ "</a><a href=/issuetracker/homeController?sort=priority_asc> < </a></td>"
					+ "<td>Assignee <a href=/issuetracker/homeController?sort=assignee_desc> >"
					+ "</a><a href=/issuetracker/homeController?sort=assignee_asc> < </a></td>"
					+ "<td>Type <a href=/issuetracker/homeController?sort=type_desc> >"
					+ "</a><a href=/issuetracker/homeController?sort=type_asc> < </a></td>"
					+ "<td>Status<a href=/issuetracker/homeController?sort=status_desc> >"
					+ "</a><a href=/issuetracker/homeController?sort=status_asc> < </a></td>"
					+ "<td>Summary <a href=/issuetracker/homeController?sort=summary_desc> > </a>"
					+ "<a href=/issuetracker/homeController?sort=summary_asc> < </a></td>");
			out.println("</thead>");

			out.println("<tbody>");
			for (IssueFromList issue : issues) {
				out.println("<tr>");
				out.println("<td> <a href ='/issuetracker/issueController?id="
						+ issue.getId() + "'>" + issue.getId() + "<a></td>");
				out.println("<td>" + issue.getPriority() + "</td>");
				out.println("<td>" + issue.getAssignee() + "</td>");
				out.println("<td>" + issue.getType() + "</td>");
				out.println("<td>" + issue.getStatus() + "</td>");
				out.println("<td>" + issue.getSummary() + "</td>");
				out.println("</tr>");
			}
		}
		out.println("</tbody>");
		out.println("</table>");
	}
}
