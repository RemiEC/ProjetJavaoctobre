package com.RemiVincent.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
			String sql= "select * from XXXXXXXXX"; 
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next())
			{
				if (username == myRs.getString("username") && password == myRs.getString("password")) {
					dic.replace("connexion_check", true);
					if (myRs.getString("admin") == "1") {
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
