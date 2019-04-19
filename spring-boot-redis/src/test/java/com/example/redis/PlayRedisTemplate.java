package com.example.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author zyd
 * @date 2018/12/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayRedisTemplate {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void set() throws InterruptedException {
        redisTemplate.opsForValue().set("1", "Hello Redis");

        Thread.sleep(TimeUnit.MINUTES.toMillis(1));
    }

}
