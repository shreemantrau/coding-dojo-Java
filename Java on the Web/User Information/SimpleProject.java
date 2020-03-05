package com.codingdojo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/SimpleProject/Home")
public class SimpleProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String language=request.getParameter("language");
		String homeTown=request.getParameter("hometown");
		
		if(homeTown == null) {
			homeTown = "Unknown";
		}
		if(language == null) {
			language = "Unknown";
		}
		if(lastName == null) {
			lastName = "Unknown";
		}
		if(name == null) {
			name = "Unknown";
		}
		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.write("<h1>"+"Welcome, " + name + " " + lastName + "</h1>");
		out.write("<h3>Your favourite language is: " + language + "</h3>");
		out.write("<h3>Your hometown is: " +homeTown + "</h3>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
