
package object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 809);
        
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        
        
        System.out.println("start");
        String code = "B20DCCN999;ABCDEF";
        oos.writeUTF(code);
        oos.flush();
        System.out.println("send code sucessfull");
        
        Student a = (Student) ois.readObject();
        System.out.println(a);
        oos.writeObject(a);
        oos.flush();
    }
}
