package com.xpncs.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpncs.models.Credentials;


public class AuthController {
	
	
	
	private ObjectMapper om = new ObjectMapper();
	
	//actually do the request
	public void userLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		
		//use your session to keep track of your user permission level
//		HttpSession sess = req.getSession();
//		sess.setAttribute("User-Role", "Admin");
		
		res.setStatus(200);
//		res.setContentType("application/json");  THIS IS AUTOMATICALLY JSON RESPONSE
		System.out.println(cred.getUsername() + " " + cred.getPass());
		res.getWriter().write(om.writeValueAsString(cred));
		System.out.println(req.getMethod());
	}
	
	
	

}
