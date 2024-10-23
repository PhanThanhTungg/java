
package TH;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.Socket;

public class DataInputStreamDataOutputStream {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("203.162.10.109",2207);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            String code = "B21DCCN775;mhs5X7EH";
            dos.writeUTF(code);
            dos.flush();
            
            int a = dis.readInt();
            int b = dis.readInt();
            
            dos.writeInt(a+b);
            dos.flush();
            dos.writeInt(a*b);
            dos.flush();
            
            dis.close();
            dos.close();
            socket.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
