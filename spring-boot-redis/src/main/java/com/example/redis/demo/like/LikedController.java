package com.example.redis.demo.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyd
 * @date 2019/01/18
 */
@RestController
@RequestMapping("/redis/")
public class LikedController {

    private final RedisLikeService likedService;

    @Autowired
    public LikedController(RedisLikeService likedService) {
        this.likedService = likedService;
    }

    @PostMapping("/like")
    public void postLike(@RequestBody OperateLikeRequest request) {
        likedService.postLike(request.getPostId(), request.getUserId());
    }

    @PostMapping("dislike")
    public void postDislike(@RequestBody OperateLikeRequest request) {
        likedService.postDislike(request.getPostId(), request.getUserId());
    }

}
