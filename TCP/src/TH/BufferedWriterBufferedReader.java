package TH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class BufferedWriterBufferedReader {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("203.162.10.109",2208);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            String sMs = "B21DCCN775;ia8PSjod\n";
            bw.write(sMs);
            bw.flush();
            
            String rMs = br.readLine();
            ArrayList<String> arl = new ArrayList<>();
            for(String x: rMs.split(",")){
                if(x.trim().endsWith(".edu")){
                    arl.add(x.trim());
                }
            }
            
            sMs = String.join(", ", arl);
            bw.write(sMs);
            bw.flush();
            br.close();
            bw.close();
            socket.close();
        } catch (Exception e) {
        }
    }
    
}
