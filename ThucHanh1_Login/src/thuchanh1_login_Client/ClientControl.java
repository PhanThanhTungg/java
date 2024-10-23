package thuchanh1_login_Client;

import Model.User;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientControl {

    private Socket mySocket;
    private String serverHost = "127.0.0.1";
    private int serverPort = 1000;

    public ClientControl() {
    }

    public Socket openConnection() {
        try {
            mySocket = new Socket(serverHost, serverPort);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return mySocket;
    }

    public boolean sendData(User user) {
        try {

            ObjectOutputStream oos
                    = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean sendKey(String key) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(key); // Gửi chuỗi key
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public ArrayList receiveKey() {
        ArrayList<?> result = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            Object o = ois.readObject();

            if (o instanceof ArrayList) {
                ArrayList list = (ArrayList) o; // Chuyển đổi đối tượng thành ArrayList

                if (list.isEmpty()) {
                    return null; // Nếu ArrayList rỗng, trả về null
                } else {
                    return list; // Nếu không rỗng, trả về ArrayList
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null; // Trả về null trong trường hợp có lỗi
        }

        return result; // Trả về kết quả
    }

    public String receiveData() {
        String result = null;
        try {
            ObjectInputStream ois
                    = new ObjectInputStream(mySocket.getInputStream());
            Object o = ois.readObject();
            if (o instanceof String) {
                result = (String) o;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return result;
    }

    public boolean closeConnection() {
        try {
            mySocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}
