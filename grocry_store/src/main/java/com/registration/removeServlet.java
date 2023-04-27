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
 * Servlet implementation class removeServlet
 */
@WebServlet("/remove-from-cartt")
public class removeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()) {
			String price = request.getParameter("price");
			if(price != null) {
				ArrayList<cart> cart_list = (ArrayList<cart>) request.getSession().getAttribute("cart-list");
				if(cart_list != null) {
					for(cart c:cart_list) {
						if(c.getPrice() == Integer.parseInt(price)) {
							cart_list.remove(cart_list.indexOf(c));
							break;
						}
					}
					response.sendRedirect("cart.jsp");
				}
			} else {
				response.sendRedirect("cart.jsp");
			}
		}
	}

}
