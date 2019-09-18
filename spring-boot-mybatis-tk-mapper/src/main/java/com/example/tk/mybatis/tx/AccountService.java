package com.example.tk.mybatis.tx;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {

    private static final Logger LOGGER = LogManager.getLogger(AccountService.class.getName());

    private final AccountMapper mapper;

    public AccountService(AccountMapper mapper) {
        this.mapper = mapper;
    }

    public Account getById(String id) {
        Account account = new Account();
        account.setId(id);

        return mapper.selectByPrimaryKey(account);
    }

    public Account getByUserId(String userId) {
        Account query = new Account();
        query.setUserId(userId);

        return mapper.selectOne(query);
    }

    public int updateBalance(String accountId, BigDecimal amount) {
        Account account = getById(accountId);
        BigDecimal add = account.getBalance().add(amount);

        Account update = new Account();
        update.setId(accountId);
        update.setBalance(add);

        return mapper.updateByPrimaryKeySelective(update);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public int updateBalanceWithReadCommitted(String accountId, BigDecimal amount) {
        int i = updateBalance(accountId, amount);
        LOGGER.info("update balance, balance: {}", amount);

        return i;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED, rollbackFor = Exception.class)
    public void getByIdWithReadUncommitted(String id) throws InterruptedException {
        Account account1 = getById(id);
        LOGGER.info("事务隔离级别：读未提交；第1次，data：{}", account1);
        Thread.sleep(2000);

        Account account2 = getById(id);
        LOGGER.info("事务隔离级别：读未提交；第2次，data：{}", account2);
        Thread.sleep(2000);

        Account account3 = getById(id);
        LOGGER.info("事务隔离级别：读未提交；第3次，data：{}", account3);
    }

}
