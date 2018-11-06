package com.blogspot.danserlesgens.value;

import java.io.Serializable;

public class OnlineAccountValue implements Serializable {
    private String user;
    private String ip;
    private String loginTime;

    public void setUser(String user) {
        this.user = user;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getUser() {
        return user;
    }

    public String getIp() {
        return ip;
    }

    public String getLoginTime() {
        return loginTime;
    }
}
