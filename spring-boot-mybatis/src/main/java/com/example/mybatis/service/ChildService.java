package com.example.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis.dao.ChildMapper;
import com.example.mybatis.dao.model.Child;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author zyd
 * @date 2019/01/16
 */
@Service
public class ChildService {

    @Autowired
    private ChildMapper childMapper;

    public List<Child> findAll() {
        return childMapper.selectList(null);
    }

    public CompletableFuture<List<Child>> findAllAsync() {
        return CompletableFuture.supplyAsync(this::findAll);
    }

    public Child findById(String id) {
        return childMapper.selectById(id);
    }

    public CompletableFuture findByIdAsync(String id) {
        return CompletableFuture.supplyAsync(() -> findById(id));
    }

    public Child find(String name) {
        LambdaQueryWrapper<Child> eq = new QueryWrapper<Child>()
                .lambda()
                .eq(Child::getName, name);

        return childMapper.selectOne(eq);
    }

}
