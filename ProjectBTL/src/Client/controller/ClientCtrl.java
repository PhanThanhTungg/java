package Client.controller;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.User;
import model.UserRequest;

public class ClientCtrl {
    private Socket Csocket;
    private String host = "localhost";
    private int port = 1609;

    public ClientCtrl() {
    }
    
    public Socket openConnection(){
        try {
            Csocket = new Socket(host,port);
            return Csocket;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void sendRequest(UserRequest userRequest){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Csocket.getOutputStream());
            oos.writeObject(userRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String recieveFlag(){
        try {
            DataInputStream dis = new DataInputStream(Csocket.getInputStream());
            String flag = dis.readUTF();
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
