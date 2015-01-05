package com.main.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.controller.configReader;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginDaoImpl implements LoginDao {
	
	 @Override
	 public boolean validate(String name, String pass) {          
	        boolean status = false;  
	        Connection conn = null;  
	        PreparedStatement pst = null;  
	        ResultSet rs = null;
			
	        String url = configReader.readConfig("url");  
	        String dbName = configReader.readConfig("dbName");  
	        String driver = configReader.readConfig("driver");  
	        String userName = configReader.readConfig("userName"); 
	        String password = configReader.readConfig("password"); 
	        try {  
	            Class.forName(driver).newInstance();  
	            conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);  
	  
	            pst = (PreparedStatement) conn.prepareStatement("select * from person where name=? and pw=?");  
	            pst.setString(1, name);  
	            pst.setString(2, pass);  
	  
	            rs = pst.executeQuery();  
	            status = rs.next();  
	  
	        } catch (Exception e) {  
	            System.out.println(e);  
	        } finally {  
	            if (conn != null) {  
	                try {  
	                    conn.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (pst != null) {  
	                try {  
	                    pst.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	            if (rs != null) {  
	                try {  
	                    rs.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	        return status;  
	 }		
}
