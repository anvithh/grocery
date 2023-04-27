package com.registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import cn.grocry_store.model.cart;

/**
 * Servlet implementation class IncreAndDecreServlet
 */
@WebServlet("/button-algebra")
public class IncreAndDecreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter();) {
			String action = request.getParameter("action");
			int price = Integer.parseInt(request.getParameter("price"));
			
			ArrayList<cart> cart_list = (ArrayList<cart>) request.getSession().getAttribute("cart-list");
			
			if(action !=null && price>=10 ) {
				if(action.equals("inc")) {
					for(cart c:cart_list) {
						if(c.getPrice() == price) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							response.sendRedirect("cart.jsp");
						}
					}
				} 
			}
		}
		
		
	}

}
