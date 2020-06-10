package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class Goods implements Serializable {
    private int Menu_ID;

    public int getMenu_ID() {
        return Menu_ID;
    }

    public void setMenu_ID(int menu_ID) {
        Menu_ID = menu_ID;
    }

    public String getMenu_Price() {
        return Menu_Price;
    }

    public void setMenu_Price(String menu_Price) {
        Menu_Price = menu_Price;
    }

    public String getMenu_Introduce() {
        return Menu_Introduce;
    }

    public void setMenu_Introduce(String menu_Introduce) {
        Menu_Introduce = menu_Introduce;
    }

    public String getMenu_Photo() {
        return Menu_Photo;
    }

    public void setMenu_Photo(String menu_Photo) {
        Menu_Photo = menu_Photo;
    }

    private String Menu_Price;
    private String Menu_Introduce;
    private String Menu_Photo;
    private String Menu_Name;

    public String getMenu_Name() {
        return Menu_Name;
    }

    public void setMenu_Name(String menu_Name) {
        Menu_Name = menu_Name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "Menu_ID=" + Menu_ID +
                ", Menu_Price='" + Menu_Price + '\'' +
                ", Menu_Introduce='" + Menu_Introduce + '\'' +
                ", Menu_Phtoto='" + Menu_Photo + '\'' +
                ", Menu_Name='" + Menu_Name + '\'' +
                '}';
    }
}
