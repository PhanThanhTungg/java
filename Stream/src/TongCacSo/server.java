
package TongCacSo;

import DaoNguocXau.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(1604);
            while(true){
                Socket cSocket = socket.accept();
                InputStream in = cSocket.getInputStream();
                OutputStream out = cSocket.getOutputStream();
                
                byte[] buffer = new byte[1024];
                int bytesRead = in.read(buffer);
                String mess = new String(buffer, 0, bytesRead);
                
                String msgToClient = "2|5|9|11";
                System.out.println("msg to Client: "+msgToClient);
                out.write(msgToClient.getBytes());
                out.flush();
                
                bytesRead = in.read(buffer);
                String result = new String(buffer, 0, bytesRead);
                System.out.println("result: "+result);
                
                in.close();
                out.close();
                cSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
