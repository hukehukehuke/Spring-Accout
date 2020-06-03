package com.huke.domain;

import java.math.BigDecimal;


public class Account {
    private Long id;
    private Long AccountId;
    private String name;
    private BigDecimal ammounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return AccountId;
    }

    public void setAccountId(Long accountId) {
        AccountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmmounts() {
        return ammounts;
    }

    public void setAmmounts(BigDecimal ammounts) {
        this.ammounts = ammounts;
    }
}
