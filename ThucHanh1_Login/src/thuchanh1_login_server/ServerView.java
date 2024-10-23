/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thuchanh1_login_server;

public class ServerView {

    public ServerView() {
        new ServerControl();
        System.out.println("not show");
        showMessage("TCP server is running...");
        System.out.println("ok show");
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
