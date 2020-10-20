package com.RemiVincent.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;



@WebServlet("/login")
public class login_servlet extends HttpServlet {
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
		Cookie [] cookies_tab = request.getCookies(); 
		if(cookies_tab != null) {
			for(Cookie cookie:cookies_tab) { 
				if(cookie.getName().equals("username_cookie")) {
					request.setAttribute("username_cookie", cookie.getValue());				
				}
			} 
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login_page.jsp"); 
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get values from fields filled by username
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Boolean admin = projetDBUtil.Check_Login(username, password).get("admin");
				
		//Check if it's correct (Check_Login)
		if (projetDBUtil.Check_Login(username, password).get("connexion_check") == true) {
			HttpSession session = request.getSession(true);
			
			//Store the variables into the session. We also send the value of admin to know what to display in the user_page
			session.setAttribute("username_session", username);
			session.setAttribute("admin_bool_session", admin);
			
			//Store the username as a cookie
			Cookie cookie = new Cookie("username_cookie", username);
			cookie.setMaxAge(60*60*24); // time in seconds, here for 24 hours 
			response.addCookie(cookie);
			
			response.sendRedirect("/ProjetJava/userPage"); 
		}
		else {
			String error_message = "Informations incorrectes";
			request.setAttribute("message_erreur", error_message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login_page.jsp"); 
			dispatcher.forward(request, response);
		}
	}
}
