package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class UserSimpInfo implements Serializable {
    private String User_Tel;

    public String getUser_Tel() {
        return User_Tel;
    }

    public void setUser_Tel(String user_Tel) {
        User_Tel = user_Tel;
    }

    private float User_Mony;
    private int Addr_ID;
    private String User_HeadImg;

    public float getUser_Mony() {
        return User_Mony;
    }

    public void setUser_Mony(float user_Mony) {
        User_Mony = user_Mony;
    }

    public int getAddr_ID() {
        return Addr_ID;
    }

    public void setAddr_ID(int addr_ID) {
        Addr_ID = addr_ID;
    }

    public String getUser_HeadImg() {
        return User_HeadImg;
    }

    public void setUser_HeadImg(String user_HeadImg) {
        User_HeadImg = user_HeadImg;
    }

    @Override
    public String toString() {
        return "UserSimpInfo{" +
                "User_Tel='" + User_Tel + '\'' +
                ", User_Mony=" + User_Mony +
                ", Addr_ID=" + Addr_ID +
                ", User_HeadImg='" + User_HeadImg + '\'' +
                '}';
    }
}
