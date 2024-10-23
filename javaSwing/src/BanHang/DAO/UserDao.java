/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanHang.DAO;

import BanHang.model.User;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDao {
    public List<User> getAllUsers(){
        try {
            List<User> users = new ArrayList<>();      
            Connection con = DataConnection.getJDBCConnection();
            String sql = "select * from user";
            
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAbout(rs.getString("ABOUT"));
                user.setFavourites(rs.getString("FAVOURITES"));
                user.setRole(rs.getString("ROLE"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            return null;
        }
    }
    
    public void addUser(User user){
        try {
            Connection con = DataConnection.getJDBCConnection();
            String sql = "INSERT INTO `ban_hang`.`user` (`NAME`, `PHONE`, `USERNAME`, `PASSWORD`, `ABOUT`, `FAVOURITES`, `ROLE`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, user.getName()); 
            preparedStatement.setString(2, user.getPhone()); 
            preparedStatement.setString(3, user.getUsername()); 
            preparedStatement.setString(4, user.getPassword()); 
            preparedStatement.setString(5, user.getAbout()); 
            preparedStatement.setString(6, user.getFavourites());
            preparedStatement.setString(7, user.getRole());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println("add user unsuccessfully");
        }
    }
    
    public void updateUser(User user){
        try {
            Connection con = DataConnection.getJDBCConnection();
            String sql = "UPDATE `ban_hang`.`user` SET `NAME` = ?, `PHONE` = ?, `USERNAME` = ?, `PASSWORD` = ?, `ABOUT` = ?, `ROLE` = ?, `FAVOURITES` = ? WHERE (`ID` = ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, user.getName()); 
            preparedStatement.setString(2, user.getPhone()); 
            preparedStatement.setString(3, user.getUsername()); 
            preparedStatement.setString(4, user.getPassword()); 
            preparedStatement.setString(5, user.getAbout()); 
            preparedStatement.setString(6, user.getFavourites());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.setInt(8, user.getId());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println("update user unsuccessfully");
        }
    }
    
    public void deleteUser(int id){
        try {
            Connection con = DataConnection.getJDBCConnection(); 
            String sql = "delete from user where id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            int rs = stm.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            System.out.println("delete user unsuccessfully");
        }
    }
    
//    public static void main(String[] args) {
//        List <User> test = new ArrayList<>();
//        test = getAllUsers();
//        for(User user:test){
//            System.out.println(user.getName());
//        }
//        
//    }
}
