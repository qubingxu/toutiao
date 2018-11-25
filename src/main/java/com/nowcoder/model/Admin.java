package com.nowcoder.model;

public class Admin {
    private int adminid;
    private String username;
    private String password;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String salt;
    public int getId() {
        return adminid;
    }

    public void setId(int id) {
        this.adminid = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
