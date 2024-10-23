
package Server.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.net.ServerSocket;
import java.net.Socket;
import model.UserRequest;
public class ServerCtrl {
    private Connection con;
    private ServerSocket sSocket;
    private int port = 1609;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private DataInputStream dis;
    private DataOutputStream dos;
    
    public ServerCtrl() {
        getDBConnection("btl", "root", "123456");
        OpenSocket(port);
        while(true){
            listening();
        }
    }
    
    private void getDBConnection(String dbName, String username,String password) {
        String dbUrl = "jdbc:mysql://localhost:3306/" + dbName;
        try {
            con = DriverManager.getConnection(dbUrl,
                    username, password);
            System.out.println("connect to database successfully");
        } catch (Exception e) {
            System.out.println("connect to database unsuccessfully");
            e.printStackTrace();
        }
    }
    private void OpenSocket(int port){
        try {
            sSocket = new ServerSocket(port);
            System.out.println("open serverSocket successfully");
        } catch (IOException e) {
            System.out.println("open serverSocket unsuccessfully");
            e.printStackTrace();
        }
    }
    private Object readObject() throws IOException, ClassNotFoundException{
        return ois.readObject();
    }
    private void UserRequestHandler(Object o){
        UserRequest userRequest = (UserRequest) o;
        if(userRequest.getFlag().equals("register")||userRequest.getFlag().equals("login")){
            new LoginCtrl(userRequest,con,this);
        }
    }
    
    public void sendFlag(String flag){
        try {
            Socket cSocket = sSocket.accept();
            dos = new DataOutputStream(cSocket.getOutputStream());
            dos.writeUTF(flag);
            dos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void listening(){
        try {
            Socket cSocket = sSocket.accept();
            System.out.println("accept clientSocket");
            ois = new ObjectInputStream(cSocket.getInputStream());
            Object o = readObject();
            
            if(o instanceof UserRequest) UserRequestHandler(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
