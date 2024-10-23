/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DaoNguocXau;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("172.188.19.218", 1605);
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            
            dout.writeUTF("B21DCCN703;ho58L9u");
            dout.flush();
            
            String msgFromServer = din.readUTF();
            StringBuilder sb = new StringBuilder(msgFromServer);
            dout.writeUTF(sb.reverse()+"");
            dout.flush();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
