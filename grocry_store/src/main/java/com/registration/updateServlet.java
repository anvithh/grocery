package com.registration;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateform")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String image= request.getParameter("image");
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerylab","root","password");
			
			PreparedStatement pst = con.prepareStatement("update products set name=?, description=?, price=?, stock=?, image=?");
			
			
			pst.setString(1, name);
			pst.setString(2, description);
			pst.setInt(3, price);
			pst.setInt(4, stock);
			pst.setString(5, image);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("choice.jsp");
			
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
