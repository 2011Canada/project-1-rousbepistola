package com.xpncs.controllers;

import com.xpncs.repo.EmployeeDAO;

public class ApproveTicket {
	EmployeeDAO ED = new EmployeeDAO();
	
	public boolean ApproveTicket(int resolver, String time_resolved, int id) {


		return ED.approvalOfTicket(resolver, time_resolved, id);

	}
	
	public boolean RejectTicket(int resolver, String time_resolved, int id) {


		return ED.rejectionOfTicket(resolver, time_resolved, id);

	}





}
