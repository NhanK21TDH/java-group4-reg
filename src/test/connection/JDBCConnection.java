package test.connection;

import java.sql.*;
import java.util.ArrayList;

public class JDBCConnection {

    public static Connection getJDBCConnection() {
        final String url = "jdbc:mysql://localhost:3306/connector";
        final String user = "root";
        final String password = "nhan9a";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String insertData(Information in) {
        String url = "jdbc:mysql://localhost:3306/connector";
        String user = "root";
        String pass = "nhan9a";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement psmnt = connection.prepareStatement("insert into register values(?,?,?,?,?,?)");
            psmnt.setString(1, in.getFirstName());
            psmnt.setString(2, in.getLastName());
            psmnt.setString(3, in.getUserName());
            psmnt.setString(4, in.getPassword());
            psmnt.setString(5, in.getPhone());
            psmnt.setString(6, in.getEmail());
            psmnt.executeUpdate();
            return "Add Successfully !";
        } catch (Exception e) {
            return "Phone number can't be more than 11 character !";
        }
        
    }

    public ArrayList<Information> getAll() {
        Connection connection = getJDBCConnection();
        ArrayList<Information> informations = new ArrayList<>();
        if (connection != null) {
            System.out.println("connection database successfull");
        } else {
            System.out.println("connection database fail");
        }
        try {
            Statement statement = connection.createStatement();
            String sql = "select*from register";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Information i = new Information();
                i.setFirstName(rs.getString("firstname"));
                i.setLastName(rs.getString("lastname"));
                i.setUserName(rs.getString("username"));
                i.setPassword(rs.getString("password"));
                i.setPhone(rs.getString("phonenumber"));
                i.setEmail(rs.getString("email"));
                informations.add(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return informations;
    }

}
