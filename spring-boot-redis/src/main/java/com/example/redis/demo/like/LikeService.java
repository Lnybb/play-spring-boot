package com.example.redis.demo.like;

import java.util.List;

/**
 * @author zyd
 * @date 2019/02/14
 */
public interface LikeService {

    /**
     * 点赞
     *
     * @param request 点赞参数
     */
    void postLike(OperateLikeRequest request);

    /**
     * 取消点赞
     *
     * @param request 取消点赞参数
     */
    void postDislike(OperateLikeRequest request);

    /**
     * 获取某个帖子点赞数
     *
     * @param postId 帖子标识
     * @return 某个帖子点赞数
     */
    long getLikeNumber(String postId);

    /**
     * 该用户是否点赞过该帖子
     *
     * @param userId 用户标识
     * @param postId 帖子标识
     * @return {@code true} 已经点赞；{@code false} 未点赞
     */
    boolean getLikeStatus(String userId, String postId);

    /**
     * 获取已点赞的帖子
     *
     * @param userId 用户标识
     * @return 帖子列表
     */
    List<ContentModel> getLikedContent(String userId);

}
