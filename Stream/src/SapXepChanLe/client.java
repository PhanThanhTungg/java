/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SapXepChanLe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class client {
    
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 807);
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            
            dout.writeUTF("B21DCCN775");
            
            String msgFromServer = din.readUTF();
            ArrayList<Integer> chan = new ArrayList<>();
            ArrayList<Integer> le = new ArrayList<>();
            for(String c: msgFromServer.split(",")){
                int x = Integer.parseInt(c);
                if(x % 2 == 0) chan.add(x);
                else le.add(x);
            }
            Collections.sort(chan);
            Collections.sort(le);
            
            String result = chan.toString()+";"+le.toString();
            dout.writeUTF(result);
            dout.flush();
            
            din.close();
            dout.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
