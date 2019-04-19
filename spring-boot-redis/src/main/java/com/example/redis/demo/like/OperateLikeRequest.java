package com.example.redis.demo.like;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zyd
 * @date 2019/01/18
 */
@Getter
@Setter
@ToString
public class OperateLikeRequest {

    private String postId;

    private String userId;

}
