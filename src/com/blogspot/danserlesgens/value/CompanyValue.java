package com.blogspot.danserlesgens.value;

import java.io.Serializable;
import java.math.BigDecimal;

public class CompanyValue implements Serializable {
    private String name;
    private String man;
    private BigDecimal manCardId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public BigDecimal getManCardId() {
        return manCardId;
    }

    public void setManCardId(BigDecimal manCardId) {
        this.manCardId = manCardId;
    }
}
