package com.nowcoder.model;

/**
 * Created by nowcoder on 2016/6/26.
 */
public class User {
    private int Userid;
    private String UserName;
    private String PassWord;
    private String salt;

    public int getId() {
        return Userid;
    }

    public void setId(int id) {
        this.Userid = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User() {

    }
    public User(String name) {
        this.UserName = name;
        this.PassWord = "";
        this.salt="";
    }


}
