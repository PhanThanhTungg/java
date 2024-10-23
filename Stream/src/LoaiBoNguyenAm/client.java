package LoaiBoNguyenAm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("172.188.19.218", 1606);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            String code = "B21DCCN703;SipOtry";
            out.write(code);
            out.flush();
            
            String msgFromServer = in.readLine();
            int i = 0;
            while(i<msgFromServer.length()){
                int x = i, y = i;
                if(Character.compare(msgFromServer.charAt(i), '-') == 0){
                    for(int j = i+1; j < msgFromServer.length();j++){
                        if(Character.isDigit(msgFromServer.charAt(j))) y = j;
                        else break;    
                    }
                    if(y!=i){
                        msgFromServer = msgFromServer.substring(0, x)+msgFromServer.substring(y+1);
                    }
                }
                else i++;
            }
            System.out.println(msgFromServer);
            
            out.write(msgFromServer);
            out.flush();
            
            in.close();
            out.close();
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
