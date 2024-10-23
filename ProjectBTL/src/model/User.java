package model;

import java.io.Serializable;

public class User  implements Serializable {
    private int id,score,win,lose,draw;
    private String username,password,fullName,status;

    public User() {
    }
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String password, String fullName,int score, int win, int lose, int draw, String status) {
        this.score = score;
        this.win = win;
        this.lose = lose;
        this.draw = draw;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Object[] toObject(){
        return new Object[]{id,username,password, fullName, score, win, lose, draw, status};
    }
    
}
