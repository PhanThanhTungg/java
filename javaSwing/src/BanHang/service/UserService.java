
package BanHang.service;

import BanHang.DAO.UserDao;
import BanHang.model.User;
import java.util.List;

public class UserService {
    private UserDao userDao;
    
    public UserService() {
        this.userDao = new UserDao();
    }
    
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    
    public void addUser(User user){
        userDao.addUser(user);
    }
    
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
}
