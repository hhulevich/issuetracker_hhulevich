package org.training.issuetracker.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.controllers.AbstractBaseController;
import org.training.issuetracker.res.Constants;

/**
 * @author Hanna Hulevich
 *
 */
public abstract class AbstractPage extends AbstractBaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String tittle;

	/**
	 *
	 */
	public AbstractPage() {
		super();
	}

	/**
	 * @return String
	 */
	public String getTittle() {
		return tittle;
	}

	/**
	 * @param tittle String
	 */
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	/**
	 * @return long
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractBaseController#performTask(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + getTittle() + "</title>");
		out.println("</head>");
		out.println("<body>");
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				Constants.HEADER_URL);
		rd.include(request, response);

		out.println("<div>");
		Object errorMessage = request.getAttribute(Constants.KEY_ERROR_MESSAGE);
		if (errorMessage != null) {
			out.println("<b class='text-error'>" + errorMessage + "</b>");
		}

		printPageContent(request, response);

		out.println("</div>");
		rd = getServletContext().getRequestDispatcher(Constants.FOOTER_URL);
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws IOException exception
	 */
	public abstract void printPageContent(HttpServletRequest request,
			HttpServletResponse response) throws IOException;

}
