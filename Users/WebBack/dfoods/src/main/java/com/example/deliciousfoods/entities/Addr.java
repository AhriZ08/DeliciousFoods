package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class Addr implements Serializable {
    private int Addr_ID;
    private String Addr;
    private String CallName;
    private String RecTel;

    public int getAddr_ID() {
        return Addr_ID;
    }

    public void setAddr_ID(int addr_ID) {
        Addr_ID = addr_ID;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public String getCallName() {
        return CallName;
    }

    public void setCallName(String callName) {
        CallName = callName;
    }

    public String getRecTel() {
        return RecTel;
    }

    public void setRecTel(String recTel) {
        RecTel = recTel;
    }

    @Override
    public String toString() {
        return "Addr{" +
                "Addr_ID=" + Addr_ID +
                ", Addr='" + Addr + '\'' +
                ", CallName='" + CallName + '\'' +
                ", RecTel='" + RecTel + '\'' +
                '}';
    }
}
