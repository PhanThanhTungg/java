package TongCacSo;

import DaoNguocXau.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("203.162.10.109", 2206 );
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            
            String code = "B21DCCN775;sz33qNna";
            out.write(code.getBytes());
            out.flush();
            
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String msgFromServer = new String(buffer, 0, bytesRead);
            int sum = 0;
            for(String x:msgFromServer.split("\\|")){
                sum += Integer.parseInt(x);
            }
            
            out.write(Integer.toString(sum).getBytes());
            out.flush();
            
            in.close();
            out.close();
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
