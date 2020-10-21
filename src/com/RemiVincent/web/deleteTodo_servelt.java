package com.RemiVincent.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/DeleteTodo")
public class deleteTodo_servelt extends HttpServlet {
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
			Boolean admin = Boolean.valueOf(request.getSession(false).getAttribute("admin_bool_session").toString());
			
			//This page displays only if the user is admin to avoid that someone lambda modifies the url and can access this page
			if (admin == true) {
				int id_Todo = Integer.parseInt(request.getParameter("TodoId"));
				projetDBUtil.Delete_Todo(id_Todo);
				
				response.sendRedirect("/ProjetJava/userPage"); 
			}
			else {
				//Redirect to error 404 page
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		}
		else {
			//Redirect to error 404 page
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
