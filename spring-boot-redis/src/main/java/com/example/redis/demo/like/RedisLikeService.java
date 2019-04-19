package com.example.redis.demo.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author zyd
 * @date 2019/01/18
 */
@Service
public class RedisLikeService {

    private RedisTemplate<String, String> redisTemplate;
    private HashOperations<String, String, String> hashOperations;
    private ValueOperations<String, String> valueOperations;

    private static final String MAP_LIKED = "MAP_LIKED";
    private static final String MAP_LIKED_COUNT = "MAP_LIKED_COUNT";

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setHashValueSerializer(RedisSerializer.string());

        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        this.valueOperations = redisTemplate.opsForValue();
    }

    /**
     * 点赞
     */
    public void postLike(String postId, String userId) {
        doCount(postId, 1);
    }

    /**
     * 取消点赞
     */
    public void postDislike(String postId, String userId) {
        doCount(postId, -1);
    }

    private void doCount(String postId, int count) {
        long timestamp = generateCountKeyTimestamp();
        String countKey = generateCountKey(timestamp);
        hashOperations.increment(countKey, postId, count);
        redisTemplate.expireAt(countKey, generateExpireAt(timestamp, 5, ChronoUnit.MINUTES));
    }

    private long generateCountKeyTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), now.getMinute()));
        return timestamp.toInstant().toEpochMilli();
    }

    private String generateCountKey(long epochMilli) {
        return MAP_LIKED_COUNT + ":" + epochMilli;
    }

    private Date generateExpireAt(long epochMilli, long amountToAdd, ChronoUnit unit) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        LocalDateTime utc = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
        return Date.from(utc.plus(amountToAdd, unit).toInstant(ZoneOffset.UTC));
    }
}
