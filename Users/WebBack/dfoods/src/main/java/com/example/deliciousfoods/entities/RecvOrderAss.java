package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class RecvOrderAss implements Serializable {
    private int rate;
    private String assContent;
    private int userID;
    private int shopID;
    private int orderID;
    private String time;
    private int assID;
    private int assUnusual;

    public int getAssID() {
        return assID;
    }

    public void setAssID(int assID) {
        this.assID = assID;
    }

    public int getAssUnusual() {
        return assUnusual;
    }

    public void setAssUnusual(int assUnusual) {
        this.assUnusual = assUnusual;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAssContent() {
        return assContent;
    }

    public void setAssContent(String assContent) {
        this.assContent = assContent;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "RecvOrderAss{" +
                "rate=" + rate +
                ", assContent='" + assContent + '\'' +
                ", userID=" + userID +
                ", shopID=" + shopID +
                ", orderID=" + orderID +
                ", time='" + time + '\'' +
                ", assID=" + assID +
                ", assUnusual=" + assUnusual +
                '}';
    }
}
