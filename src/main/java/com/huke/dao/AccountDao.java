package com.huke.dao;

import com.huke.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {

    void save(Account account);

    void update(Account account);

    void find(Long accountId);

    void delete(Long accountId);

    void transfer();

    Account findAccountByName(String name);
}
