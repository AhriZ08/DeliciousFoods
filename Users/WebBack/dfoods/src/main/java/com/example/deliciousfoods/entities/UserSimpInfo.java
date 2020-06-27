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
    private String User_HeadImg;

    public float getUser_Mony() {
        return User_Mony;
    }

    public void setUser_Mony(float user_Mony) {
        User_Mony = user_Mony;
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
                ", User_HeadImg='" + User_HeadImg + '\'' +
                '}';
    }
}
