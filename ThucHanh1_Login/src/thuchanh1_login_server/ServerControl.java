/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh1_login_server;

import Model.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import tcp.client.User;

public class ServerControl {

    private Connection con;
    private ServerSocket myServer;
    private int serverPort = 1000;

    public ServerControl() {
        getDBConnection("thuchanh1ltm", "root", "123456");
        openServer(serverPort);
        while (true) {
            listenning();
        }
    }

    private void getDBConnection(String dbName, String username,
            String password) {

        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
        try {
            con = DriverManager.getConnection(dbUrl,
                    username, password);
            System.out.println("connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openServer(int portNumber) {
        try {
            myServer = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void listenning() {
//        try {
//            Socket clientSocket = myServer.accept();
//            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
//            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
//            Object o = ois.readObject();
//            if (o instanceof User) {
//                User user = (User) o;
//                if (checkUser(user)) {
//                    oos.writeObject("ok");
//                } else {
//                    oos.writeObject("false");
//                }
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    private void listenning() {
        try {
            Socket clientSocket = myServer.accept();
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            Object o = ois.readObject();

            if (o instanceof User) {
                User user = (User) o; // Chuyển đổi đối tượng thành User

                if (checkUser(user)) {
                    oos.writeObject("ok");
                } else {
                    oos.writeObject("false");
                }
            } else if (o instanceof String) {
                String key = (String) o; // Nếu nhận được String
                ArrayList<User> users = checkKey(key); // Gọi hàm kiểm tra khóa và nhận danh sách
                oos.writeObject(users);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkUser(User user) throws Exception {
        String query = "Select * FROM user WHERE username ='"
                + user.getUserName()
                + "' AND password ='" + user.getPassword() + "'";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    private ArrayList<User> checkKey(String key) throws Exception {
        ArrayList<User> users = new ArrayList<>();
        String query = "SELECT * FROM user WHERE fullName LIKE '" + key + "%'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setPhone(rs.getString("phone"));
                users.add(user); // Thêm người dùng vào danh sách
            }

        } catch (Exception e) {
            throw e; // Ném lại ngoại lệ nếu có lỗi
        }

        return users; // Trả về danh sách người dùng tìm thấy
    }
}
