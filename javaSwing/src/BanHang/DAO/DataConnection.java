package BanHang.DAO;


import java.sql.DriverManager;
import java.sql.Connection;


public class DataConnection {
    public static Connection getJDBCConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/ban_hang";
            String user = "root";
            String password = "123456";
            Connection connection  = DriverManager.getConnection(url,user,password);

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
      
            return null;
        }
    }
}

