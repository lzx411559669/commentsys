package com.lzx.comment.control;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lzx.comment.dao.CommentDAO;
import com.lzx.comment.dataobject.CommentDO;
import com.lzx.comment.model.Comment;
import com.lzx.comment.model.Paging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CommentController
 * @Author 刘正星
 * @Date 2020/7/12 13:36
 **/
@Controller
public class CommentController {
    @Autowired
    private CommentDAO commentDAO;

    @GetMapping("/comments")
    @ResponseBody
    public Paging<CommentDO> getAll(@RequestParam(value = "pageNum" ,required = false,defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize",required = false,defaultValue = "15") Integer pageSize) {
        pageNum = pageNum == null ? 0:pageNum;
        Page<CommentDO> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> commentDAO.findAll());

        return new Paging<>(page.getPageNum(), page.getPageSize(), page.getPages(), page.getTotal(), page.getResult());
    }

    @PostMapping("/comment")
    @ResponseBody
    public CommentDO save(@RequestBody CommentDO commentDO) {
        commentDAO.add(commentDO);
        return commentDO;
    }

    @PostMapping("/comment/update")
    @ResponseBody
    public CommentDO update(@RequestBody CommentDO commentDO) {
        commentDAO.update(commentDO);
        return commentDO;
    }

    @GetMapping("/comment/del")
    @ResponseBody
    public boolean delete(@RequestParam("id") long id) {
        return commentDAO.delete(id) > 0;
    }

    @GetMapping("/comment/findByRefId")
    @ResponseBody
    public List<Comment> findByRefId(@RequestParam("refId") String refId) {
        return commentDAO.findByRefId(refId);
    }

    @PostMapping("/comment/batchAdd")
    @ResponseBody
    public boolean batchAdd(@RequestParam("list") List<CommentDO> commentDOS) {
        return commentDAO.batchAdd(commentDOS) > 0;
    }

    @GetMapping("/comment/findByUserIds")
    @ResponseBody
    public List<CommentDO> findByUserIds(@RequestParam("userIds") List<Long> ids) {
        return commentDAO.findByUserIds(ids);
    }


}
