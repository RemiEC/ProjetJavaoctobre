package com.RemiVincent.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userPage")
public class userPage_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the session values
		String username = request.getSession(false).getAttribute("username_session").toString();
		Boolean admin = Boolean.valueOf(request.getSession(false).getAttribute("admin_bool_session").toString());
		
		//test to know if admin is well received and converted
		System.out.println(admin);
		//end of the test
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_page.jsp"); 
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	//When logging out will be created, don't forget to put "session.invalidate()" to remove variables form the session
}
