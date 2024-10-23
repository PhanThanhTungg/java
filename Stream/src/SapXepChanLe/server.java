
package SapXepChanLe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(807);
            while(true){
                Socket cSocket = serverSocket.accept();
                DataInputStream din = new DataInputStream(cSocket.getInputStream());
                DataOutputStream dout = new DataOutputStream(cSocket.getOutputStream());
                System.out.println("MSV: " + din.readUTF()); 
                
           
                dout.writeUTF("2,15,4,3,6,8,10,7,1");
                dout.flush();
                
                String result = din.readUTF();
                System.out.println("result: "+result);
                
                din.close();
                dout.close();
                cSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
}
