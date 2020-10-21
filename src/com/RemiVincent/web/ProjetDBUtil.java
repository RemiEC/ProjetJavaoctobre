package com.RemiVincent.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

public class ProjetDBUtil {
	private DataSource dataSource;

	public ProjetDBUtil(DataSource thedataSource) {
		dataSource = thedataSource;
	}
	
	public Map<String,Boolean> Check_Login(String username,String password){
		Connection myConn=null; 
		Statement myStmt = null;
		ResultSet myRs= null; 
		
		//Create a dictionnary to store determine if the login informations are correct and if so, to know if the user is an admin or not
		Map<String,Boolean> dic= new HashMap<String,Boolean>();
		dic.put("connexion_check", false);
		dic.put("admin", false);
		
		//value returned in case of error (all the fields false)
		Map<String,Boolean> dic_error = dic;
		
		try 
		{
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "SELECT * FROM Project1_Web_Dynamic_App_DB.user_info;"; 
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				//Get values from the database
				String username_in_DB = myRs.getString("username");
				String password_in_DB = myRs.getString("password");
				String admin_in_DB = myRs.getString("admin");
				
				//compare it with the values entered by the user
				//I used the equal function because the "==" operator did not work
				if (username.equals(username_in_DB) && password.equals(password_in_DB)) {
					dic.replace("connexion_check", true);
					if (admin_in_DB.equals("1")) {
						dic.replace("admin", true);
					}
				}
			}
			return dic; 
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage()); 
			return dic_error;
		}
		
		finally
		{
			close(myConn,myStmt,myRs);
		}
	}
	
	public ArrayList<Todo> Get_Todo (){
		
		Connection myConn=null; 
		Statement myStmt = null;
		ResultSet myRs= null; 
		ArrayList<Todo> list_Todos = new ArrayList<Todo>();
		
		try 
		{
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "SELECT * FROM Project1_Web_Dynamic_App_DB.todo;"; 
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				//Get values from the database
				int id = myRs.getInt("idtodo");
				String text = myRs.getString("texttodo");
				list_Todos.add(new Todo(id,text));
				
			}
			return list_Todos; 
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage()); 
			return null;
		}
		
		finally
		{
			close(myConn,myStmt,myRs);
		}
	}
	
	public void Delete_Todo(int Todo_id) {
		
		Connection myConn=null;
		PreparedStatement myStmt = null; 
		try {
			myConn = dataSource.getConnection();
			String sql = "delete from Project1_Web_Dynamic_App_DB.todo where idtodo=?";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1,Todo_id); 
			
			myStmt.execute();
		}
		catch(Exception e) {
			System.out.println(e.getMessage()); 
		}
		
		finally { 
			close(myConn,myStmt,null);
		} 
	}
 	
	public void Add_Todo(String description) {
		Connection myConn=null;
		PreparedStatement myStmt = null; 
		try {
			myConn = dataSource.getConnection();
			String query = "insert into Project1_Web_Dynamic_App_DB.todo (texttodo) values (?);";
			myStmt = myConn.prepareStatement(query);
			
			myStmt.setString(1, description);
			
			myStmt.execute();	
		}
		catch(Exception e) {
			System.out.println(e.getMessage()); 
		}
		
		finally { 
			close(myConn,myStmt,null);
		} 
	}

	public void Edit_Todo(int Todo_id, String new_description) {
		Connection myConn=null;
		PreparedStatement myStmt = null; 
		try {
			myConn = dataSource.getConnection();
			String sql = "update Project1_Web_Dynamic_App_DB.todo set texttodo=? where idtodo=?";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, new_description); 
			myStmt.setInt(2, Todo_id); 
			
			myStmt.execute();
		}
		catch(Exception e) {
			System.out.println(e.getMessage()); 
		}
		
		finally { 
			close(myConn,myStmt,null);
		} 
	}
	
	public Todo Fetch_Todo(int TodoId) {
		Connection myConn=null; 
		Statement myStmt = null;
		ResultSet myRs= null; 
		Todo todo = null;
		
		try 
		{
			myConn = dataSource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "SELECT * FROM Project1_Web_Dynamic_App_DB.todo where idtodo="+TodoId+";"; 
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				//Get values from the database
				int id = myRs.getInt("idtodo");
				String text = myRs.getString("texttodo");
				todo = new Todo(id,text);
			}
			return todo; 
		} 
		
		catch (Exception e) {
			System.out.println(e.getMessage()); 
			return null;
		}
		
		finally
		{
			close(myConn,myStmt,myRs);
		}
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try
		{
			if(myStmt!=null)
			{
				myStmt.close();
			}
			if(myRs!=null)
			{
				myRs.close();
			}
			if(myConn!=null)
			{
				myConn.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()); 
		}
	}
}
