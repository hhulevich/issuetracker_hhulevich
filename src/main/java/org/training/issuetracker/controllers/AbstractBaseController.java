package org.training.issuetracker.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractBaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AbstractBaseController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}
	
	abstract protected void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
    protected void jump(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
	    rd.forward(request, response);
    }
    
    protected void jumpError(String url, String errorMes, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("errorMessage", errorMes);
    	RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
	    rd.forward(request, response);
    }
}
