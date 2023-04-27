package com.registration;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class registrationServlet
 */
@WebServlet("/uploadform")
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String building = request.getParameter("building");
		int consumption = Integer.parseInt(request.getParameter("consumption"));
	
		
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itmajor","root","password");
			PreparedStatement pst = con.prepareStatement("insert into energy(name,building,consumption) values(?,?,?) ");
			pst.setString(1, name);
			pst.setString(2, building);
			pst.setInt(3, consumption);
			
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("main.jsp");
			
			if ( rowCount > 0) {
				request.setAttribute("status", "success");
			}
			else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
