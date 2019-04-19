package com.example.redis.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zyd
 * @date 2019/01/21
 */
@Component
@Slf4j
public class PubAndSubDemo {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String CHANNEL = "sendKey";

//    @Scheduled(cron = "*/5 * * * * ?")
    public void send() {
        long msg = System.currentTimeMillis();
        redisTemplate.convertAndSend(CHANNEL, String.valueOf(msg));
        log.info("send msg {}", msg);
    }

}
