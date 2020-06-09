package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class RecvAddr implements Serializable {
    private String addr;
    private String recTel;
    private String callName;
    private int addr_ID;
    private int User_ID;

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
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

    public int getAddr_ID() {
        return addr_ID;
    }

    public void setAddr_ID(int addr_ID) {
        this.addr_ID = addr_ID;
    }

    @Override
    public String toString() {
        return "RecvAddr{" +
                "addr='" + addr + '\'' +
                ", recTel='" + recTel + '\'' +
                ", callName='" + callName + '\'' +
                ", addr_ID=" + addr_ID +
                ", User_ID=" + User_ID +
                '}';
    }
}
