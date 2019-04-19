package com.example.mybatis.service;

import com.example.mybatis.dao.model.Child;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author zyd
 * @date 2019/01/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChildServiceTest {

    @Autowired
    private ChildService childService;

    @Test
    public void findAll() {
        List<Child> children = childService.findAll();
        System.out.println(children);

        CompletableFuture<List<Child>> childrenAsync = childService.findAllAsync();
        System.out.println(childrenAsync);
    }

    @Test
    public void find() {
        Child child = childService.find("kids");

        System.out.println(child);
    }

}
