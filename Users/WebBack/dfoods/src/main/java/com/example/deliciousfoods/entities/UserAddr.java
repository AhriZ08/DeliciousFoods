package com.example.deliciousfoods.entities;

import java.io.Serializable;
import java.util.List;

public class UserAddr implements Serializable {
    private int User_ID;
    private float User_Mony;
    private List<Addr> addrList;

    public float getUser_Mony() {
        return User_Mony;
    }

    public void setUser_Mony(float user_Mony) {
        User_Mony = user_Mony;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public List<Addr> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<Addr> addrList) {
        this.addrList = addrList;
    }

    @Override
    public String toString() {
        return "UserAddr{" +
                "User_ID=" + User_ID +
                ", User_Mony=" + User_Mony +
                ", addrList=" + addrList +
                '}';
    }
}
