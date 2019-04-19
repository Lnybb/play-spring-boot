package com.example.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisApplicationTests {

    @Autowired
    private UserDao userDao;

    private String userId = "2";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private User getUser() {
        return new User(userId, UUID.randomUUID().toString(), new Date());
    }

    @Test
    public void f1() {
//        userDao.save(getUser());
//        userDao.getById(userId);
    }

    @Test
    public void f2() {
//        userDao.saveAsHash(getUser());
    }

    @Test
    public void json() throws JsonProcessingException {
        String s = new ObjectMapper().writeValueAsString(getUser());
        System.out.println(s);
    }

    @Test
    public void renameAndCreateKey() {

        String key = "MAP_LIKED_COUNT:current";
        redisTemplate.rename(key, "MAP_LIKED_COUNT:" + System.currentTimeMillis());
    }

}

