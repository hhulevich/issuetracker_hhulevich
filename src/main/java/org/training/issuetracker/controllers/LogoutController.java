package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.training.issuetracker.res.Constants;

/**
 * @author Hanna Hulevich
 *
 */
public class LogoutController extends AbstractBaseController {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see org.training.issuetracker.controllers.AbstractBaseController#performTask(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void performTask(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute(Constants.KEY_USER);
		jump(Constants.LOGIN_PAGE_URL, request, response);
	}

}
