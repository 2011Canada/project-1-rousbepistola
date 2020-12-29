package com.xpncs.repo;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xpncs.models.Reimbursement;
import com.xpncs.models.User;
import com.xpncs.util.ConnectionFactory;



public class EmployeeDAO {
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	

	
	
	
//	-----------------------------------------------------------LOGIN AND GET EMPLOYEE CREDENTIALS--------------------------------------------------------------------------------
	
	public User login(String username, String pass) {
		Connection conn = this.cf.getConnection();
		User loginCredentials = null;
		
		
			try {
				String sql = "select * from \"user\" u \r\n"
						+ "inner join user_roles ur \r\n"
						+ "on u.user_id = ur.user_id \r\n"
						+ "where username = '"+username+"' and pass = '"+pass+"'";
				
				Statement s = conn.createStatement();
				ResultSet res = s.executeQuery(sql);
				
				while(res.next()) {
					loginCredentials = new User(res.getInt("user_id"),res.getString("fname"), res.getString("lname"), res.getString("username"), res.getString("pass"), res.getString("email"), res.getString("user_role"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	

			return loginCredentials;


	}
	
//	-----------------------------------------------------------POST REIMBURSEMENT REQUEST--------------------------------------------------------------------------------
	
	public boolean postReimbursement(Reimbursement reimbursement) {
		boolean isPosted = false;
		Connection conn = this.cf.getConnection();
		
		
		try {
			String sql = "insert into reimbursement (amount, time_submitted, description, author, resolver, status, \"type\")\r\n"
					+ "values ("+reimbursement.getAmount()+", '"+reimbursement.getTimeSubmitted()+"', '"+reimbursement.getDescription()+"', "+reimbursement.getAuthor()+" , null, "+reimbursement.isStatus()+", '"+reimbursement.getType()+"')";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			

			isPosted = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			isPosted = true;
			System.out.println(isPosted);
		} 
		
		
	
		
		return isPosted;
	}
	
	
//	-------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
}
