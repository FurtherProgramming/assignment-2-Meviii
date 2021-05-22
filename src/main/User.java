package main;

import main.model.LoginModel;
import sun.rmi.runtime.Log;

public class User {
    public LoginModel lm = new LoginModel();
    private String username;

    public User() {
    }

    public User(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String toString(){
        return "Username: " + username;
    }
}
