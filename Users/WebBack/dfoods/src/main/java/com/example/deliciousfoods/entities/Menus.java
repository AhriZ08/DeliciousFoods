package com.example.deliciousfoods.entities;

import java.io.Serializable;
import java.util.List;

public class Menus implements Serializable {
    private int Type_ID;
    private String Type_Name;
    List<Goods> goodsList;

    public int getType_ID() {
        return Type_ID;
    }

    public void setType_ID(int type_ID) {
        Type_ID = type_ID;
    }

    public String getType_Name() {
        return Type_Name;
    }

    public void setType_Name(String type_Name) {
        Type_Name = type_Name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Menus{" +
                "Type_ID=" + Type_ID +
                ", Type_Name='" + Type_Name + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
