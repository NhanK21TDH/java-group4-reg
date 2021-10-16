/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.connection;

import java.sql.*;

public class JDBCStatement {
    public static void main(String[] args) {
        try {
            Connection conn = TestConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            
            String sql = "select*from register";
            
            ResultSet rs = statement.executeQuery(sql);
            
            while( rs.next()){
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int phonenumber = rs.getInt("phonenumber");
                String email = rs.getString("email");
                
                
                System.out.println(firstname +"     "+ lastname+"    "+username +"   "+password+"    "+phonenumber+"   "+email);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        
    }
}
