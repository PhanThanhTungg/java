
package object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(809);
        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("client accept");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            String rMs = ois.readUTF();
            System.out.println("code from client: "+ rMs);

            Student a = new Student(rMs, 2, 3.8f);
            oos.writeObject(a);
            oos.flush();

            Student b = (Student)ois.readObject();
            System.out.println(b);
        }
    }
    
}
