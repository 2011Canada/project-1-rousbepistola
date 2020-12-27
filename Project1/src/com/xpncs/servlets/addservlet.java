package com.xpncs.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/add")
public class addservlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;
		k=k*k;
		
		
//		res.getWriter().println(k);
		
//		req.setAttribute("k", k);

		
//DISPATCHER SAME SERVER
//		RequestDispatcher rd = req.getRequestDispatcher("sq");
//		rd.forward(req, res);
		
		
		
//		for transferring data outside your server
		//this will not send the original req and res
//		res.sendRedirect("sq?k="+k);
		
		

	
		
//		EXAMPLE ON SESSION
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
		
		
//		EXAMPLE ON COOKIES
		
		Cookie cookie = new Cookie("k" , k+""); //the empty string will make the k into a string cause param is String String
		res.addCookie(cookie);
		
		res.sendRedirect("sq");
		
		
	}

}
