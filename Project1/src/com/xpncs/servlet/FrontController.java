package com.xpncs.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpncs.controllers.ApproveTicket;
import com.xpncs.controllers.AuthController;
import com.xpncs.controllers.ReimbursementRequestController;
import com.xpncs.controllers.ShowEveryTicket;
import com.xpncs.controllers.ShowTicketController;
import com.xpncs.models.Credentials;
import com.xpncs.models.Reimbursement;
import com.xpncs.models.RequestTypeGetter;
import com.xpncs.models.Tickets;
import com.xpncs.models.User;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuthController authController = new AuthController();
	private ObjectMapper om = new ObjectMapper();
	
	protected void directControlRouter(HttpServletRequest req, HttpServletResponse res) throws IOException  {
		

		
		//TYPE OF REQUEST FOR PROPER HANDLING
		String login = "loginRequest";
		String reimbursementRequest = "reimbursementRequest";
		String showTickets = "showTickets";
		String showEveryTicket = "showEveryTicket";
		String approveTicket = "approveTicket";
		String rejectTicket = "rejectTicket";
		
		

		
		//This is getting the type of request to know how to handle a request
		RequestTypeGetter typeOfRequest = om.readValue(req.getInputStream(), RequestTypeGetter.class);
		String handleRequest = typeOfRequest.getTypeOfRequest();
		System.out.println(handleRequest);
		
		
		
		//-------------------------------------------------HANDLING LOGIN REQUEST-------------------------------------------------
		if(handleRequest.equals(login)) {
			System.out.println("LOGIN REQUEST HANDLER");
			
			Credentials cred = new Credentials(typeOfRequest.getUsername(), typeOfRequest.getPass());
			
			//res.getWriter().write(om.writeValueAsString(cred)); // writes as json response
			User loggedInUser = authController.userLogin(cred.getUsername(), cred.getPass());
			
			if(loggedInUser != null) {
				res.setStatus(200);
				res.getWriter().write(om.writeValueAsString(loggedInUser));
			} else {
				res.setStatus(401);
				res.getWriter().write("unauthorized");
			}
			
			
		}
		
		//-------------------------------------------------HANDLING  REQUEST FOR REIMBURSEMENT-------------------------------------------------
		if(handleRequest.equals(reimbursementRequest)) {
			System.out.println("REIMBURSEMENT REQUEST HANDLER");
			Reimbursement reimburse = new Reimbursement(typeOfRequest.getAmount(), typeOfRequest.getTimeSubmitted(), typeOfRequest.getDescription(), typeOfRequest.getAuthor(), typeOfRequest.isStatus(), typeOfRequest.getType());
			
			ReimbursementRequestController postR = new ReimbursementRequestController();
			boolean isPosted = postR.postReimbursement(reimburse);
			
			
			if(isPosted) {
				res.setStatus(200);	
				System.out.println("succesfully posted request for reimbursement!");
			}else {
				res.setStatus(401);
			}
			

			
			
		}
		
		
		//-------------------------------------------------HANDLING  REQUEST FOR SHOWING TICKETS-------------------------------------------------
		if(handleRequest.equals(showTickets)) {
			System.out.println("SHOWTICKET REQUEST HANDLER");
			int author = typeOfRequest.getAuthor();
			ShowTicketController stc = new ShowTicketController();
			
			
			ArrayList<Tickets> tickets = stc.showTickets(author);
			res.getWriter().write(om.writeValueAsString(tickets));
			


		}
		
		//-------------------------------------------------HANDLING  REQUEST FOR SHOWING ALL TICKETS-------------------------------------------------
		if(handleRequest.equals(showEveryTicket)) {
			System.out.println("SHOWEVERYTICKET REQUEST HANDLER");
			int resolver = typeOfRequest.getResolver();
			ShowEveryTicket set = new ShowEveryTicket();
			
			
			ArrayList<Tickets> tickets = set.showEveryTicket(resolver);
			res.getWriter().write(om.writeValueAsString(tickets));

		}
		
		//-------------------------------------------------HANDLING  REQUEST FOR APPROVAL OF A TICKET-------------------------------------------------
		if(handleRequest.equals(approveTicket)) {
			System.out.println("APPROVETICKET REQUEST HANDLER");
			int resolver = typeOfRequest.getResolver();
			String time_resolved = typeOfRequest.getTimeResolved();
			int id = typeOfRequest.getId();
			
			
			ApproveTicket at = new ApproveTicket();
			at.ApproveTicket(resolver, time_resolved, id);
			res.getWriter().write(om.writeValueAsString("A TICKET HAS BEEN APPROVED"));

		}
		
		//-------------------------------------------------HANDLING  REQUEST FOR REJECTION OF A TICKET-------------------------------------------------
		if(handleRequest.equals(rejectTicket)) {
			System.out.println("REJECTTICKET REQUEST HANDLER");
			int resolver = typeOfRequest.getResolver();
			String time_resolved = typeOfRequest.getTimeResolved();
			int id = typeOfRequest.getId();
			
			
			ApproveTicket at = new ApproveTicket();
			at.RejectTicket(resolver, time_resolved, id);
			res.getWriter().write(om.writeValueAsString("A TICKET HAS BEEN REJECTED SUCCESFULLY"));

		}
		
		
		
		
		
	}
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		directControlRouter(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		try {
			directControlRouter(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		directControlRouter(request, response);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		directControlRouter(request, response);
	}
	
	public void cleanUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().close();
	}
}
