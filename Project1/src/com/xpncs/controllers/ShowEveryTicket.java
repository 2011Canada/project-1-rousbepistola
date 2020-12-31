package com.xpncs.controllers;

import java.util.ArrayList;

import com.xpncs.models.Tickets;
import com.xpncs.repo.EmployeeDAO;

public class ShowEveryTicket {
	
	
	
	
EmployeeDAO ED = new EmployeeDAO();
	
	
	
	//actually do the request
	public ArrayList<Tickets> showEveryTicket(int resolver){
		
		
		ArrayList<Tickets> tickets = ED.showAllTickets(resolver);
		
		return tickets;
	}

}
