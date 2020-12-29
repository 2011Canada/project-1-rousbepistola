package com.xpncs.controllers;

import java.io.IOException;

import com.xpncs.models.Reimbursement;
import com.xpncs.models.User;
import com.xpncs.repo.EmployeeDAO;

public class ReimbursementRequestController {
	
EmployeeDAO ED = new EmployeeDAO();
	
	
	
	//actually do the request
	public boolean postReimbursement(Reimbursement reimbursement){
		boolean isPosted = false;
		
		isPosted = ED.postReimbursement(reimbursement);
		
		return isPosted;
	}

}
