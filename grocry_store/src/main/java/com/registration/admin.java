package com.registration;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
/**
 * Servlet implementation class login
 */

@WebServlet("/adminform")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerylab?useSSL=false","root","password");
			PreparedStatement pst = con.prepareStatement("select * from admin where username = ? and password = ? ");
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				session.setAttribute("name", rs.getString("username"));
				dispatcher = request.getRequestDispatcher("choice.jsp");
			}
			else {
				request.setAttribute("status","failed");
				dispatcher = request.getRequestDispatcher("index.jsp");
			}
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
