package com.xpncs.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpncs.models.Credentials;
import com.xpncs.models.User;
import com.xpncs.repo.EmployeeDAO;


public class AuthController {
	EmployeeDAO ED = new EmployeeDAO();
	
	
	
	//actually do the request
	public User userLogin(String username, String pass) throws IOException {
		
		
		User loggedInUser = ED.login(username, pass);
		
		
		
		return loggedInUser;
	}
	
	

	

}
