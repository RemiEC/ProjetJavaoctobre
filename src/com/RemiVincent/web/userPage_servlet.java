package com.RemiVincent.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/userPage")
public class userPage_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProjetDBUtil projetDBUtil;

	@Resource(name="jdbc/Project1_Web_Dynamic_App_DB")
	private DataSource dataSource;
		
	@Override
	public void init() throws ServletException {
		super.init();
		projetDBUtil = new ProjetDBUtil(dataSource);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false).getAttribute("username_session") != null) {
			request.setAttribute("list_todo",projetDBUtil.Get_Todo());
			RequestDispatcher dispatcher = request.getRequestDispatcher("user_page.jsp"); 
			dispatcher.forward(request, response);
		}
		else {
			//Redirect to error 404 page
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("text_todo");
		projetDBUtil.Add_Todo(description);
		
		response.sendRedirect("/ProjetJava/userPage"); 
	}
	
	
	//When logging out will be created, don't forget to put "session.invalidate()" to remove variables form the session
}
