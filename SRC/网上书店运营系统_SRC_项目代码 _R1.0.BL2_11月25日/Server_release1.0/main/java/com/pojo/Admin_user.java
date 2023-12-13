package com.pojo;

public class Admin_user {
    private String uname;
    private String upwd;

    public Admin_user() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "Admin_user{" +
                "uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
