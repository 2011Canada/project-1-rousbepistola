package com.xpncs.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		ServletContext ctx = getServletContext();
		ServletConfig con = getServletConfig();
		String name2 = con.getInitParameter("edmond");
		String name = ctx.getInitParameter("lname");
//		
//		response.getWriter().println("hi <br>" + name);
//		response.getWriter().println("hi <br>" + name2);
		
		JSONArray json = new JSONArray();
		
		JSONObject user = new JSONObject();
		user.put("name", "rous");
		user.put("age", 26);
		user.put("lname", "e");
		
		JSONObject user2 = new JSONObject();
		user.put("name", "rene");
		user.put("age", 28);
		user.put("lname", "solomon");
		
		json.put(user);
		json.put(user2);
		
		response.setContentType("application/json");
        response.getWriter().write(json.toString());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
