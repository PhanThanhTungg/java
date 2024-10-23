
package model;

import java.io.Serializable;

public class UserRequest implements Serializable{
    private String flag;
    private User user;

    public UserRequest(String flag, User user) {
        this.flag = flag;
        this.user = user;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
