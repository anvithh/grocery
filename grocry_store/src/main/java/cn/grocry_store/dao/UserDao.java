package cn.grocry_store.dao;


import java.sql.*;
import cn.grocry_store.model.*;

public class UserDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public user userLogin(String username, String password) {
		user User = null;
        try {
            query = "select * from users where username=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	User = new user();
            	User.setUsername(rs.getString("username"));
            	User.setName(rs.getString("name"));
            	User.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return User;
    }
}
