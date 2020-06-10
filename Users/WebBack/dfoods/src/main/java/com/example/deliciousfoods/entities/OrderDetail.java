package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class OrderDetail extends OrderSimpInfo implements Serializable {
    private String Order_RecAddr;
    private String Order_SpendTime;
    private String Order_FormatNum;

    public String getOrder_RecAddr() {
        return Order_RecAddr;
    }

    public void setOrder_RecAddr(String order_RecAddr) {
        Order_RecAddr = order_RecAddr;
    }

    public String getOrder_SpendTime() {
        return Order_SpendTime;
    }

    public void setOrder_SpendTime(String order_SpendTime) {
        Order_SpendTime = order_SpendTime;
    }

    public String getOrder_FormatNum() {
        return Order_FormatNum;
    }

    public void setOrder_FormatNum(String order_FormatNum) {
        Order_FormatNum = order_FormatNum;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "Order_RecAddr='" + Order_RecAddr + '\'' +
                ", Order_SpendTime='" + Order_SpendTime + '\'' +
                ", Order_FormatNum='" + Order_FormatNum + '\'' +
                '}';
    }
}
