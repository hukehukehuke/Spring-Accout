package com.huke.service;

import com.huke.domain.Account;

import java.math.BigDecimal;

public interface AccountSerivce {


    void save(Account account);

    void update(Account account);

    void find(Long accountId);

    void delete(Long accountId);

    public void transfer(String sourceName, String targetName, BigDecimal money);
}
