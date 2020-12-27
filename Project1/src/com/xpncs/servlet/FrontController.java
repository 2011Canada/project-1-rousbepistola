package com.xpncs.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import com.xpncs.controllers.AuthController;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuthController authController = new AuthController();
	
	protected void directControlRouter(HttpServletRequest req, HttpServletResponse res) throws IOException  {
		
		authController.userLogin(req, res);
		System.out.println("should have result here^^^");
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
}
