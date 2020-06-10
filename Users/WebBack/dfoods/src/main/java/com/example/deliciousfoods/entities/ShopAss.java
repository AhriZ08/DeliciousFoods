package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class ShopAss implements Serializable {
    private String User_Name;
    private String User_HeadImg;
    private String Ass_Content;
    private String Ass_Time;
    private int Ass_Rate;

    public String getUser_Name() {
        return User_Name;
    }

    public String getUser_HeadImg() {
        return User_HeadImg;
    }

    public void setUser_HeadImg(String user_HeadImg) {
        User_HeadImg = user_HeadImg;
    }

    public String getAss_Content() {
        return Ass_Content;
    }

    public void setAss_Content(String ass_Content) {
        Ass_Content = ass_Content;
    }

    public String getAss_Time() {
        return Ass_Time;
    }

    public void setAss_Time(String ass_Time) {
        Ass_Time = ass_Time;
    }

    public int getAss_Rate() {
        return Ass_Rate;
    }

    public void setAss_Rate(int ass_Rate) {
        Ass_Rate = ass_Rate;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    @Override
    public String toString() {
        return "ShopAss{" +
                "User_Name='" + User_Name + '\'' +
                ", User_HeadImg='" + User_HeadImg + '\'' +
                ", Ass_Content='" + Ass_Content + '\'' +
                ", Ass_Time='" + Ass_Time + '\'' +
                ", Ass_Rate=" + Ass_Rate +
                '}';
    }
}
