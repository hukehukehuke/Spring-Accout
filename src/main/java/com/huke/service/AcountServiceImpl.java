package com.huke.service;

import com.huke.dao.AccountDao;
import com.huke.domain.Account;
import com.huke.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AcountServiceImpl implements AccountSerivce {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionManager transactionManager;

    @Override
    public void save(Account account) {
        this.accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        this.accountDao.update(account);
    }

    @Override
    public void find(Long accountId) {
        if (accountId != null) {
            this.accountDao.find(accountId);
        }
    }

    @Override
    public void delete(Long accountId) {
        if (accountId != null) {
            this.accountDao.delete(accountId);
        }
    }

    /**
     *
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money     转出金额
     */
    @Override
    public void transfer(String sourceName, String targetName, BigDecimal money) {
        Account accountBySourceName = this.accountDao.findAccountByName(sourceName);
        Account accountByTargetName = this.accountDao.findAccountByName(targetName);
        int i = accountBySourceName.getAmmounts().intValue() - money.intValue();
        accountBySourceName.setAmmounts(BigDecimal.valueOf(i));
        int i2 = accountByTargetName.getAmmounts().intValue() + money.intValue();
        accountByTargetName.setAmmounts(BigDecimal.valueOf(i2));
        this.accountDao.update(accountBySourceName);
        this.accountDao.update(accountByTargetName);
    }
}
