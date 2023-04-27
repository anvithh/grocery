package cn.grocry_store.dao;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.grocry_store.model.Product;
import cn.grocry_store.model.cart;

public class ProductDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public ProductDao(Connection con) {
		super();
		this.con = con;
	}
    
    
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        try {

            query = "select * from energy limit 10";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Product row = new Product();
                row.setName(rs.getString("name"));
                row.setDescription(rs.getString("building"));
                row.setPrice(rs.getInt("consumption"));
            

                products.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return products;
    }
    
    
    /*public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            query = "select * from products where id=? ";

	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Product();
	                row.setPrice(rs.getInt("consumption"));
	                row.setName(rs.getString("name"));
	                row.setDescription(rs.getString("building"));
	             
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    } */
    
    
    
    public List<cart> getCartProducts(ArrayList<cart> cartList) {
    	List<cart> products = new ArrayList<cart>();
    	
    	try {
    		if(cartList.size() > 0) {
    			for(cart item:cartList) {
    				query = "select * from products where price = ?";
    				pst = this.con.prepareStatement(query);
    				pst.setInt(1, item.getPrice());
    				rs = pst.executeQuery();
    				while(rs.next()) {
    					cart row = new cart();
    					row.setPrice(rs.getInt("consumption"));
    					row.setName(rs.getString("name"));
    					row.setDescription(rs.getString("building"));
    					row.setPrice(rs.getInt("consumption")*item.getQuantity());
    					row.setQuantity(item.getQuantity());
    					products.add(row);
    					
    				}
    			}
    		}
    	} catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	return products;
    }
    
    public int getTotalCartPrice(ArrayList<cart> cartList) {
    	int sum=0;
    	try {
    		if(cartList.size()>0) {
    			for(cart item:cartList) { 
    				query = "select price from products where price=?";
    				pst = this.con.prepareStatement(query);
    				pst.setInt(1, item.getPrice());
    				rs = pst.executeQuery();
    				while(rs.next()) {
    					sum += rs.getInt("price")*item.getQuantity();    				}
    	}
    }
} catch(Exception e) {
	e.printStackTrace();
}
    	return sum;
    }
}