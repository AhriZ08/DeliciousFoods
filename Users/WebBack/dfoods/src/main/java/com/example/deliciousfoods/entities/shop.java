package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class shop implements Serializable {
    private int Shop_ID;
    private String Shop_Name;
    private String Shop_Qrade;
    private String Shop_Sort;
    private int Shop_SellTotal;
    private String Shop_RunTime;
    private String Shop_RunStartCost;
    private String Shop_RunCost;
    private String Shop_AvgCost;
    private String Shop_Image;
    private String Shop_Distance;

    public int getShop_ID() {
        return Shop_ID;
    }

    public void setShop_ID(int shop_ID) {
        Shop_ID = shop_ID;
    }

    public String getShop_Name() {
        return Shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        Shop_Name = shop_Name;
    }

    public String getShop_Qrade() {
        return Shop_Qrade;
    }

    public void setShop_Qrade(String shop_Qrade) {
        Shop_Qrade = shop_Qrade;
    }

    public String getShop_Sort() {
        return Shop_Sort;
    }

    public void setShop_Sort(String shop_Sort) {
        Shop_Sort = shop_Sort;
    }

    public int getShop_SellTotall() {
        return Shop_SellTotal;
    }

    public void setShop_SellTotall(int shop_SellTotall) {
        Shop_SellTotal = shop_SellTotall;
    }

    public String getShop_RunTime() {
        return Shop_RunTime;
    }

    public void setShop_RunTime(String shop_RunTime) {
        Shop_RunTime = shop_RunTime;
    }

    public String getShop_RunStartCost() {
        return Shop_RunStartCost;
    }

    public void setShop_RunStartCost(String shop_RunStartCost) {
        Shop_RunStartCost = shop_RunStartCost;
    }

    public String getShop_RunCost() {
        return Shop_RunCost;
    }

    public void setShop_RunCost(String shop_RunCost) {
        Shop_RunCost = shop_RunCost;
    }

    public String getShop_AvgCost() {
        return Shop_AvgCost;
    }

    public void setShop_AvgCost(String shop_AvgCost) {
        Shop_AvgCost = shop_AvgCost;
    }

    public String getShop_Image() {
        return Shop_Image;
    }

    public void setShop_Image(String shop_Image) {
        Shop_Image = shop_Image;
    }

    public String getShop_Distance() {
        return Shop_Distance;
    }

    public void setShop_Distance(String shop_Distance) {
        Shop_Distance = shop_Distance;
    }

    @Override
    public String toString() {
        return "shop{" +
                "Shop_ID=" + Shop_ID +
                ", Shop_Name='" + Shop_Name + '\'' +
                ", Shop_Qrade='" + Shop_Qrade + '\'' +
                ", Shop_Sort='" + Shop_Sort + '\'' +
                ", Shop_SellTotal=" + Shop_SellTotal +
                ", Shop_RunTime='" + Shop_RunTime + '\'' +
                ", Shop_RunStartCost='" + Shop_RunStartCost + '\'' +
                ", Shop_RunCost='" + Shop_RunCost + '\'' +
                ", Shop_AvgCost='" + Shop_AvgCost + '\'' +
                ", Shop_Image='" + Shop_Image + '\'' +
                ", Shop_Distance='" + Shop_Distance + '\'' +
                '}';
    }
}
