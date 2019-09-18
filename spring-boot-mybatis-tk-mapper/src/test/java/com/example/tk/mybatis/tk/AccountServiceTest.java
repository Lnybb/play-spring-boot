package com.example.tk.mybatis.tk;

import com.example.tk.mybatis.tx.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void f1() throws InterruptedException {
        new Thread(() -> {
//            while (true) {
//                accountService.getByIdWithReadUncommitted("1");
//                try {
//                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000));
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    e.printStackTrace();
//                }
//            }
            try {
                accountService.getByIdWithReadUncommitted("1");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                accountService.updateBalanceWithReadCommitted("1", new BigDecimal("1"));
//                try {
//                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000));
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    e.printStackTrace();
//                }
            }
        }).start();

        TimeUnit.MINUTES.sleep(5);
    }
}
