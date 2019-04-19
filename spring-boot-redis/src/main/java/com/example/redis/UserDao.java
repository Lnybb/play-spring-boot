package com.example.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zyd
 * @date 2018-12-20
 */
@Service
@Slf4j
public class UserDao {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public User save(User user) {
        redisTemplate.opsForValue().set(user.getId(), user);
        log.info("invoke save, user info: {}", user);

        return user;
    }

    public User saveAsHash(User user) {
        Map<String, Object> map = new Jackson2HashMapper(new ObjectMapper(), false).toHash(user);
        redisTemplate.opsForHash().putAll(user.getId(), map);
        log.info("invoke saveAsHash, user info: {}", user);

        return user;
    }

    public User getById(String id) {
        User user = (User) redisTemplate.opsForValue().get(id);
        log.info("invoke get, user info: {}", user);

        return user;
    }

}
