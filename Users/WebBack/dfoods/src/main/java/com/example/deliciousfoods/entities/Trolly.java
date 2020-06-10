package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class Trolly implements Serializable {
    private int Trolly_Num;
    private float Trolly_Price;
    private String Menu_Name;
    private String Menu_Photo;

    public String getMenu_Photo() {
        return Menu_Photo;
    }

    public void setMenu_Photo(String menu_Photo) {
        Menu_Photo = menu_Photo;
    }

    public int getTrolly_Num() {
        return Trolly_Num;
    }

    public void setTrolly_Num(int trolly_Num) {
        Trolly_Num = trolly_Num;
    }

    public float getTrolly_Price() {
        return Trolly_Price;
    }

    public void setTrolly_Price(float trolly_Price) {
        Trolly_Price = trolly_Price;
    }

    public String getMenu_Name() {
        return Menu_Name;
    }

    public void setMenu_Name(String menu_Name) {
        Menu_Name = menu_Name;
    }

    @Override
    public String toString() {
        return "Trolly{" +
                "Trolly_Num=" + Trolly_Num +
                ", Trolly_Price=" + Trolly_Price +
                ", Menu_Name='" + Menu_Name + '\'' +
                ", Menu_Photo='" + Menu_Photo + '\'' +
                '}';
    }
}
