package com.lzx.comment.service.impl;

import com.lzx.comment.dao.CommentDAO;
import com.lzx.comment.dataobject.CommentDO;
import com.lzx.comment.model.Comment;
import com.lzx.comment.model.Result;
import com.lzx.comment.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommentServiceImpl
 * @Author 刘正星
 * @Date 2020/7/18 16:24
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Result<Comment> post(String refId, long userId, long parentId, String content) {
        Result<Comment> result = new Result<>();

        if (StringUtils.isEmpty(refId)||StringUtils.isEmpty(content)){
            result.setCode("500");
            result.setMessage("refId,userId,content不能为空");
            return result;
        }
        String body = StringEscapeUtils.escapeHtml4(content);
        CommentDO commentDO = new CommentDO();
        commentDO.setContent(body);
        commentDO.setParentId(parentId);
        commentDO.setRefId(refId);
        commentDO.setUserId(userId);
        commentDAO.add(commentDO);
        result.setSuccess(true);
        result.setData(commentDO.toModel());
        return result;
    }

    @Override
    public Result<List<Comment>> query(String refId) {
        Result<List<Comment>> result = new Result<>();
        //查询所有的评论记录包含回复的
        List<Comment> comments = commentDAO.findByRefId(refId);
//构建 map 结构
        Map<Long, Comment> commentMap = new HashMap<>();
//初始化一个虚拟根节点，0 可以对应的是所有一级评论的父亲
        commentMap.put(0L, new Comment());
//把所有的评论转换为 map 数据
        comments.forEach(comment -> commentMap.put(comment.getId(), comment));
// 再次遍历评论数据
        comments.forEach(comment -> {
            //得到父评论
            Comment parent = commentMap.get(comment.getParentId());
            if (parent != null) {
                // 初始化 children 变量
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                // 在父评论里添加回复数据
                parent.getChildren().add(comment);
            }
        });
// 得到所有的一级评论
        List<Comment> data = commentMap.get(0L).getChildren();
        result.setSuccess(true);
        result.setData(data);

        return result;
    }
}
