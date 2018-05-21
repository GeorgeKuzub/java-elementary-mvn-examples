package com.hillel.io.serial.entities;

import java.io.Serializable;

public class Auth implements Serializable {
    private String loginName;
    private transient String password;
    private transient int idd;

    public Auth(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
        this.idd = 77;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", idd=" + idd +
                '}';
    }
}
