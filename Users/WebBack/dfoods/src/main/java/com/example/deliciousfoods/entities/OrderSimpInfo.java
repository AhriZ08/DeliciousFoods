package com.example.deliciousfoods.entities;

import java.io.Serializable;
import java.util.List;

public class OrderSimpInfo implements Serializable {
    private int Order_ID;
    private String Order_State;
    private int Order_PayType;
    private String Shop_Name;
    private float Order_Total;
    private List<Trolly> trollyList;
    private String Order_Time;
    private String Shop_Image;
    private String Shop_RunCost;
    private int Shop_ID;

    public int getShop_ID() {
        return Shop_ID;
    }

    public void setShop_ID(int shop_ID) {
        Shop_ID = shop_ID;
    }

    public String getShop_RunCost() {
        return Shop_RunCost;
    }

    public void setShop_RunCost(String shop_RunCost) {
        Shop_RunCost = shop_RunCost;
    }

    public String getOrder_Time() {
        return Order_Time;
    }

    public void setOrder_Time(String order_Time) {
        Order_Time = order_Time;
    }

    public String getShop_Image() {
        return Shop_Image;
    }

    public void setShop_Image(String shop_Image) {
        Shop_Image = shop_Image;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int order_ID) {
        Order_ID = order_ID;
    }

    public String getOrder_State() {
        return Order_State;
    }

    public void setOrder_State(String order_State) {
        Order_State = order_State;
    }

    public int getOrder_PayType() {
        return Order_PayType;
    }

    public void setOrder_PayType(int order_PayType) {
        Order_PayType = order_PayType;
    }

    public String getShop_Name() {
        return Shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        Shop_Name = shop_Name;
    }

    public float getOrder_Total() {
        return Order_Total;
    }

    public void setOrder_Total(float order_Total) {
        Order_Total = order_Total;
    }

    public List<Trolly> getTrollyList() {
        return trollyList;
    }

    public void setTrollyList(List<Trolly> trollyList) {
        this.trollyList = trollyList;
    }

    @Override
    public String toString() {
        return "OrderSimpInfo{" +
                "Order_ID=" + Order_ID +
                ", Order_State='" + Order_State + '\'' +
                ", Order_PayType=" + Order_PayType +
                ", Shop_Name='" + Shop_Name + '\'' +
                ", Order_Total=" + Order_Total +
                ", trollyList=" + trollyList +
                ", Order_Time='" + Order_Time + '\'' +
                ", Shop_Image='" + Shop_Image + '\'' +
                ", Shop_RunCost='" + Shop_RunCost + '\'' +
                ", Shop_ID=" + Shop_ID +
                '}';
    }
}
