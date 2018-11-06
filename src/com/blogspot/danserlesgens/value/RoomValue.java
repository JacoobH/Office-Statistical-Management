package com.blogspot.danserlesgens.value;

import java.io.Serializable;
import java.math.BigDecimal;

public class RoomValue implements Serializable {
    private BigDecimal id;
    private String comName;
    private boolean situation;
    private double money;

    public BigDecimal getId() {
        return id;
    }

    public String getComName() {
        return comName;
    }

    public boolean getSituation() {
        return situation;
    }

    public double getMoney() {
        return money;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public void setSituation(boolean situation) {
        this.situation = situation;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
