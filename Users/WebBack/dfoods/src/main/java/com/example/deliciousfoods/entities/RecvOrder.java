package com.example.deliciousfoods.entities;

import java.io.Serializable;
import java.util.List;

public class RecvOrder implements Serializable {
    private int orderID;
    private int userID;
    private String recAddr;
    private String recTel;
    private String callName;
    private float total;
    private int payType;
    private List<Cart> cart;
    private String orderTime;
    private String orderState;
    private int orderShopID;

    public int getOrderShopID() {
        return orderShopID;
    }

    public void setOrderShopID(int orderShopID) {
        this.orderShopID = orderShopID;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRecAddr() {
        return recAddr;
    }

    public void setRecAddr(String recAddr) {
        this.recAddr = recAddr;
    }

    public String getRecTel() {
        return recTel;
    }

    public void setRecTel(String recTel) {
        this.recTel = recTel;
    }

    public String getCallName() {
        return callName;
    }

    public void setCallName(String callName) {
        this.callName = callName;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "RecvOrder{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", recAddr='" + recAddr + '\'' +
                ", recTel='" + recTel + '\'' +
                ", callName='" + callName + '\'' +
                ", total=" + total +
                ", payType=" + payType +
                ", cart=" + cart +
                ", orderTime='" + orderTime + '\'' +
                ", orderState='" + orderState + '\'' +
                ", orderShopID=" + orderShopID +
                '}';
    }
}
