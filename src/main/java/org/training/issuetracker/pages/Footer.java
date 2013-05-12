package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controllers.AbstractBaseController;

/**
 * @author Hanna Hulevich
 *
 */
public class Footer extends AbstractBaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = -8066344082725831223L;

	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractBaseController#performTask(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<div style='background-color: #D4F6FA;'>");
		out.println("<b>developed by Hanna Hulevich</b>");
		out.println("</div>");

	}
}
