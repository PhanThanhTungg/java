
package TH;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class InputStreamOutputStream {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("203.162.10.109",2206);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            
            String ms = "B21DCCN775;sz33qNna\n";
            os.write(ms.getBytes());
            os.flush();
            
            byte[] buffer = new byte[1024];
            int byteRead = is.read(buffer);
            String rMs = new String(buffer, 0, byteRead);
            System.out.println(rMs);
            
            int sum = 0;
            for(String x: rMs.split("\\|")){
                sum+= Integer.parseInt(x);
            }
            
            ms = sum+"";
            os.write(ms.getBytes());
            os.flush();
            
            is.close();
            os.close();
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
