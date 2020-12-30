package com.xpncs.controllers;

import java.util.ArrayList;

import com.xpncs.models.Reimbursement;
import com.xpncs.models.Tickets;
import com.xpncs.repo.EmployeeDAO;

public class ShowTicketController {
	
	
	
EmployeeDAO ED = new EmployeeDAO();
	
	
	
	//actually do the request
	public ArrayList<Tickets> showTickets(int author){
		
		
		ArrayList<Tickets> tickets = ED.showTickets(author);
		
		return tickets;
	}

}
