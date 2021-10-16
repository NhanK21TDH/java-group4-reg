
package test.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static Connection getJDBCConnection(){
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
    
    public static void main(String[] args) {
        Connection connection = getJDBCConnection();
        if(connection != null){
            System.out.println("connection database successfull");
        }else{
            System.out.println("connection database fail");
        }
    }
    
}
