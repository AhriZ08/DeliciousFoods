package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class User implements Serializable {
    private int User_ID;
    private String User_LoginName;
    private String User_Name;
    private String User_Pwd;
    private String User_Tel;
    private int User_Money;
    private int User_Freeze;
    private String User_HeadImg;

    public String getUser_HeadImg() {
        return User_HeadImg;
    }

    public void setUser_HeadImg(String user_HeadImg) {
        User_HeadImg = user_HeadImg;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_LoginName() {
        return User_LoginName;
    }

    public void setUser_LoginName(String user_LoginName) {
        User_LoginName = user_LoginName;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Pwd() {
        return User_Pwd;
    }

    public void setUser_Pwd(String user_Pwd) {
        User_Pwd = user_Pwd;
    }

    public String getUser_Tel() {
        return User_Tel;
    }

    public void setUser_Tel(String user_Tel) {
        User_Tel = user_Tel;
    }

    public int getUser_Money() {
        return User_Money;
    }

    public void setUser_Money(int user_Money) {
        User_Money = user_Money;
    }

    public int getUser_Freeze() {
        return User_Freeze;
    }

    public void setUser_Freeze(int user_Freeze) {
        User_Freeze = user_Freeze;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_ID=" + User_ID +
                ", User_LoginName='" + User_LoginName + '\'' +
                ", User_Name='" + User_Name + '\'' +
                ", User_Pwd='" + User_Pwd + '\'' +
                ", User_Tel='" + User_Tel + '\'' +
                ", User_Money=" + User_Money +
                ", User_Freeze=" + User_Freeze +
                ", User_HeadImg='" + User_HeadImg + '\'' +
                '}';
    }
}
