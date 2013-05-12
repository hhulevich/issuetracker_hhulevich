package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.issuetracker.res.Constants;

/**
 * @author Hanna Hulevich
 *
 */
public abstract class AbstractBaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public AbstractBaseController() {
		super();
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException exception
	 * @throws IOException exception
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException exception
	 * @throws IOException exception
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException exception
	 * @throws IOException exception
	 */
	protected abstract void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;

	/**
	 * @param url String
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException exception
	 * @throws IOException exception
	 */
	protected void jump(String url, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @param url String
	 * @param errorMes String
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException exception
	 * @throws IOException exception
	 */
	protected void jumpError(String url, String errorMes,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute(Constants.KEY_ERROR_MESSAGE, errorMes);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @return String
	 */
	protected String getRealPath() {
		return getServletConfig().getServletContext().getRealPath("/")
				+ "WEB-INF\\classes\\";
	}
}
