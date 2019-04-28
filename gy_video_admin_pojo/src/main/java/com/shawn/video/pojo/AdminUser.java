package com.shawn.video.pojo;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/4/28 0028
 */
public class AdminUser {
    private String username;
    private String password;
    private String usertoken;

    public AdminUser(String username, String password, String usertoken) {
        this.usertoken = usertoken;
        this.username = username;
        this.password = password;
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

    public String getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken;
    }
}
