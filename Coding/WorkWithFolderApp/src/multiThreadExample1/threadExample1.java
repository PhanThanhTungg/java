/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multiThreadExample1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

class LogWritter implements Runnable{ // extends Thread
    private String FileName,name;
    private long time;
    
    public LogWritter(String name, String fileName, long time){
        this.name = name; // super(name)
        this.FileName = fileName;
        this.time = time;
    }

    public String getName() {
        return name;
    }
    
    
    public void run(){
        for(int i = 0; i< 10; i++){
            try {
                BufferedWriter Writer = new BufferedWriter(new FileWriter(FileName, true));
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String strDateNow = sdf.format(date);
                Writer.write(getName()+"-"+strDateNow+"-Log"+i+"\n");
                Writer.close();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }
    
}

public class threadExample1 {

    public static void main(String[] args) {
        LogWritter lw1 = new LogWritter("thread1","logtest.txt", 0);
        LogWritter lw2 = new LogWritter("thread2","logtest.txt", 0);
        new Thread(lw1).start();
        new Thread(lw2).start();
        
//        lw1.start();
//        lw2.start();
    }
    
}
