package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.comments.CommentView;
import org.training.issuetracker.issues.IssueView;
import org.training.issuetracker.res.Constants;

/**
 * @author Hanna Hulevich
 *
 */
public class IssuePage extends AbstractPage {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public IssuePage() {
		super();
		setTittle("Issue Page");
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.pages.AbstractPage#printPageContent(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void printPageContent(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		@SuppressWarnings("unchecked")
		List<CommentView> comments = (List<CommentView>) request
				.getAttribute(Constants.KEY_COMMENTS_LIST);
		IssueView issue = (IssueView) request.getAttribute(Constants.KEY_ISSUE);
		PrintWriter out = response.getWriter();
		out.println("<table border='1'>");
		out.println("<tbody>");
		out.println("<tr><td>ID</td><td>" + issue.getId() + "</td></tr>");
		out.println("<tr><td>Create Date</td><td>" + issue.getCreateDate()
				+ "</td></tr>");
		out.println("<tr><td>Created By</td><td>" + issue.getCreatedBy()
				+ "</td></tr>");
		out.println("<tr><td>Modify Date</td><td>" + issue.getModifyDate()
				+ "</td></tr>");
		out.println("<tr><td>Modified By </td><td>" + issue.getModifiedBy()
				+ "</td></tr>");
		out.println("<tr><td>Summary</td><td>" + issue.getSummary()
				+ "</td></tr>");
		out.println("<tr><td>Description</td><td>" + issue.getDescription()
				+ "</td></tr>");
		out.println("<tr><td>Status</td><td>" + issue.getStatus()
				+ "</td></tr>");
		out.println("<tr><td>Resolution</td><td>" + issue.getResolution()
				+ "</td></tr>");
		out.println("<tr><td>Type</td><td>" + issue.getType() + "</td></tr>");
		out.println("<tr><td>Priority </td><td>" + issue.getPriority()
				+ "</td></tr>");
		out.println("<tr><td>Project </td><td>" + issue.getProject()
				+ "</td></tr>");
		out.println("<tr><td>Build found</td><td>" + issue.getBuildFound()
				+ "</td></tr>");
		out.println("<tr><td>Assignee</td><td>");
		out.println(issue.getAssignee());
		out.println("</td></tr>");
		out.println("</tbody>");
		out.println("</table>");
		if (!comments.isEmpty()) {
			out.println("<h1> Comments</h1>");
			for (CommentView comment : comments) {
				out.println("<div>");
				out.println("<b>" + comment.getText());
				out.println("<table>");
				out.println("<tbody>");
				out.println("<tr><td>Added By</td><td>" + comment.getAddedBy()
						+ "</td></tr>");
				out.println("<tr><td>Add Date</td><td>" + comment.getAddDate()
						+ "</td></tr>");
				out.println("</table>");
				out.println("</tbody>");
				out.println("</div>");
			}
		}
	}
}
