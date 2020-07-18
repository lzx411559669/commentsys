package com.lzx.comment.service;

import com.lzx.comment.model.Comment;
import com.lzx.comment.model.Result;

import java.util.List;

/**
 * @InterfaceName CommentService
 * @Author 刘正星
 * @Date 2020/7/18 16:23
 **/
public interface CommentService {
    /**
     * 发布评论
     * @param refId
     * @param userId
     * @param parentId
     * @param content
     * @return
     */
    public Result<Comment> post(String refId,long userId,long parentId,String content);
    /**
     * 查询评论
     *
     * @param refId
     * @return
     */
    public Result<List<Comment>> query(String refId);
}
