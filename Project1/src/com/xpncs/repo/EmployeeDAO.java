package com.xpncs.repo;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.xpncs.models.Reimbursement;
import com.xpncs.models.Tickets;
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


	
	
//	---------------------------------------------------------------SHOW TICKET REQUEST----------------------------------------------------------------------------
	public ArrayList<Tickets> showTickets(int author) {
		
		Connection conn = this.cf.getConnection();
		int Author = author;
		ArrayList<Tickets> tickets = new ArrayList<>();
		Tickets ticket;
		
		
			try {
				String sql = "select * from reimbursement r \r\n"
						+ "where author = "+Author+"";
				
				Statement s = conn.createStatement();
				ResultSet res = s.executeQuery(sql);
				
				while(res.next()) {
					tickets.add(ticket = new Tickets(res.getInt("id"),res.getDouble("amount"), res.getString("time_submitted"), res.getString("time_resolved"), res.getString("description"), res.getInt("author"), res.getInt("resolver"), res.getBoolean("status"), res.getString("type")));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	

		return tickets;
	}


	
//	-----------------------------------------------------------SHOW ALL TICKETS-------------------------------------------------------------------------------
	
	public ArrayList<Tickets> showAllTickets(int resolver) {
		// TODO Auto-generated method stub
		
		Connection conn = this.cf.getConnection();
		int Resolver = resolver;
		ArrayList<Tickets> tickets = new ArrayList<>();
		Tickets ticket;
		
		
			try {
				String sql = "select * from reimbursement r \r\n"
						+ "inner join \"user\" u ON r.author = u.user_id ";
				
				Statement s = conn.createStatement();
				ResultSet res = s.executeQuery(sql);
				
				while(res.next()) {
					tickets.add(ticket = new Tickets(res.getInt("id"),res.getDouble("amount"), res.getString("time_submitted"), res.getString("time_resolved"), res.getString("description"), 
													res.getInt("author"), res.getInt("resolver"), res.getBoolean("status"), res.getString("type"), res.getString("fname"), res.getString("lname") ));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	

		return tickets;
	}


	
	
	

//	------------------------------------------------------TICKET APPROVAL-------------------------------------------------------------------------------------
	
	public boolean approvalOfTicket(int resolver, String time_resolved, int id) {
		boolean isApproved = false;
		Connection conn = this.cf.getConnection();
		
		
			try {
				String sql = "UPDATE xpncs.reimbursement\r\n"
						+ "	SET resolver="+resolver+",status=true,time_resolved='"+time_resolved+"'\r\n"
						+ "	WHERE id="+id+";\r\n"
						+ "";
				
				Statement s = conn.createStatement();
				ResultSet res = s.executeQuery(sql);
				
				isApproved = true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("check db if updated");
				isApproved = true;
			} 
		
		return isApproved;
		
	}


	
//	------------------------------------------------------TICKET REJECTION-------------------------------------------------------------------------------------
	
	public boolean rejectionOfTicket(int resolver, String time_resolved, int id) {
		boolean isApproved = false;
		Connection conn = this.cf.getConnection();
		
		
			try {
				String sql = "UPDATE xpncs.reimbursement\r\n"
						+ "	SET resolver="+resolver+",time_resolved='"+time_resolved+"'\r\n"
						+ "	WHERE id="+id+";\r\n"
						+ "";
				
				Statement s = conn.createStatement();
				ResultSet res = s.executeQuery(sql);
				
				isApproved = true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("check db if updated");
				isApproved = true;
			} 
		
		return isApproved;
	}
	
}
