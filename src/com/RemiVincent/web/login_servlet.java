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


@WebServlet("/login")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProjetDBUtil projetDBUtil;

	@Resource(name="jdbc/studentdb")
	private DataSource dataSource;
		
	@Override
	public void init() throws ServletException {
		super.init();
		projetDBUtil = new ProjetDBUtil(dataSource);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login_page.jsp"); 
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get values from fields filled by username
		String username = request.getParameter("username");
		String password = request.getParameter("password");
				
		//Check if it's correct (Check_Login)
		if (projetDBUtil.Check_Login(username, password).get("connexion_check") == true) {
			//GIVE THE VALUE OF ADMIN OR NOT INTO THE SERVER SO THAT WE KNOW WHAT TO DISPLAY ON THE USER PAGE
			//response.sendRedirect("/user_page");
		}
		else {
			String error_message = "Informations incorrectes";
			request.setAttribute("message_erreur", error_message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login_page.jsp"); 
			dispatcher.forward(request, response);
		}
	}
}
