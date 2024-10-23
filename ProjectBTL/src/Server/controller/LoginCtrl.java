
package Server.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.UserRequest;

public class LoginCtrl {
    private Connection con;
    private UserRequest userRequest;
    private ServerCtrl serverCtrl;
    
    public LoginCtrl(UserRequest userRequest,Connection con, ServerCtrl serverCtrl) {
        this.con = con;
        this.userRequest = userRequest;
        this.serverCtrl = serverCtrl;   
        if(userRequest.getFlag().equals("register")) registerHandler();
        else if(userRequest.getFlag().equals("login")) LoginHandler();
    }
    
    private void registerHandler(){
        User user = userRequest.getUser();
        String sql = "INSERT INTO `btl`.`user` (`username`, `password`, `fullName`, `score`, `win`, `lose`, `draw`, `status`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, user.getUsername());
            prepareStatement.setString(2, user.getPassword());
            prepareStatement.setString(3, user.getFullName());
            prepareStatement.setInt(4, user.getScore());
            prepareStatement.setInt(5, user.getWin());
            prepareStatement.setInt(6, user.getLose());
            prepareStatement.setInt(7, user.getDraw());
            prepareStatement.setString(8, user.getStatus());
            int rs = prepareStatement.executeUpdate();
            System.out.println(String.format("Register successfully - username: %s",user.getUsername()));
        } catch (SQLException ex) {
            Logger.getLogger(LoginCtrl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Register unsuccessfully");
        }
        
    }
    
    private void LoginHandler(){
        User user = userRequest.getUser();
        String sql = "select * from user where username=? and password =?";
        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, user.getUsername());
            prepareStatement.setString(2, user.getPassword());
            ResultSet rs = prepareStatement.executeQuery();
            if(rs.next()){
                serverCtrl.sendFlag("login successfully");
            }
            else serverCtrl.sendFlag("login unsuccessfully");
        } catch (SQLException ex) {
            Logger.getLogger(LoginCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
