package com.example.deliciousfoods.entities;

import java.io.Serializable;

public class RtAddr implements Serializable {
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "RtAddr{" +
                "status=" + status +
                ", Msg='" + Msg + '\'' +
                ", object=" + object +
                '}';
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String Msg;
    private Object object;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
