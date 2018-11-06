package com.blogspot.danserlesgens.value;

public class AccountValue {
    private String user;
    private String password;
    private String power;

    public void setUser(String user){ this.user = user; }
    public void setPassword(String password){ this.password = password; }
    public void setPower(String power){ this.power = power; }

    public String getUser(){ return user; }
    public String getPassword(){ return password; }
    public String getPower(){ return power; }
}
