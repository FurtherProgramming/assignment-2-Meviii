package main;

public class UserHolder {
    private User username;
    private final static UserHolder INSTANCE = new UserHolder();

    private UserHolder(){}

    public static UserHolder getInstance(){
        return INSTANCE;
    }
    public void setUser(User username) {
        this.username = username;
    }

    public User getUser() {
        return this.username;
    }
}
