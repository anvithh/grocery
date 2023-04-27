package com.registration;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.catalina.User;

import cn.grocry_store.connection.DbCon;
import cn.grocry_store.dao.OrderDao;
import cn.grocry_store.model.Order;
import cn.grocry_store.model.cart;
import cn.grocry_store.model.user;

/**
 * Servlet implementation class OrderNowServlet
 */
@WebServlet("/order-noww")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            
			Date date = new Date(0);

            user auth = (user) request.getSession().getAttribute("auth");

            if (auth != null) {
                String productId = request.getParameter("id");
                int productQuantity = Integer.parseInt(request.getParameter("quantity"));
                if (productQuantity <= 0) {
                	productQuantity = 1;
                }
                Order orderModel = new Order();
                orderModel.setOrderId(Integer.parseInt(productId));
                orderModel.setName(auth.getName());
                orderModel.setQuantity(productQuantity);
                orderModel.setDate(formatter.format(date));

                OrderDao orderDao = new OrderDao(DbCon.getConnection());
                boolean result = orderDao.insertOrder(orderModel);
                if (result) {
                    ArrayList<cart> cart_list = (ArrayList<cart>) request.getSession().getAttribute("cart-list");
                    if (cart_list != null) {
                        for (cart c : cart_list) {
                            if (c.getPrice() == Integer.parseInt("price")) {
                                cart_list.remove(cart_list.indexOf(c));
                                break;
                            }
                        }
                    }
                    response.sendRedirect("orders.jsp");
                } else {
                    out.println("order failed");
                }
            } else {
                response.sendRedirect("login.jsp");
            }

        } catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}