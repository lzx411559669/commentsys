package com.lzx.comment.api;

import com.lzx.comment.model.Comment;
import com.lzx.comment.model.Result;
import com.lzx.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName CommentAPI
 * @Author 刘正星
 * @Date 2020/7/18 16:48
 **/
@RestController
public class CommentAPI {
    @Autowired
    private CommentService commentService;

    @PostMapping("/api/comment/post")
    public Result post(@RequestParam("refId") String refId, @RequestParam("parentId") long parentId, @RequestParam("content") String content, HttpServletRequest request) {
        long userId = (long) request.getSession().getAttribute("userId");
        return commentService.post(refId, userId, parentId, content);

    }

    @GetMapping("/api/comment/query")
    public Result<List<Comment>> query(@RequestParam("refId") String refId) {
        return commentService.query(refId);
    }


}
