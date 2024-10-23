
package DaoNguocXau;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(1605);
            while(true){
                Socket cSocket = socket.accept();
                DataInputStream din = new DataInputStream(cSocket.getInputStream());
                DataOutputStream dout = new DataOutputStream(cSocket.getOutputStream());
                
                String code = din.readUTF();
                
                String msgToClient = "day la chuoi";
                System.out.println("msg to Client: "+msgToClient);
                dout.writeUTF(msgToClient);
                dout.flush();
                
                String result = din.readUTF();
                System.out.println("result: "+result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
