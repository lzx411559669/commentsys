package com.lzx.comment.dataobject;

import com.lzx.comment.model.Comment;
import com.lzx.comment.model.User;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName CommentDO
 * @Author 刘正星
 * @Date 2020/7/12 12:48
 **/
@Data
public class CommentDO {
    private long id;
    private String refId;
    private long userId;
    private String content;
    private long parentId;
    private LocalDateTime gmtCreated;
    private LocalDateTime gmtModified;


    /**
     * DO 转换为 Model
     *
     * @return
     */
    public Comment toModel() {
        Comment comment = new Comment();
        comment.setId(getId());
        comment.setGmtCreated(getGmtCreated());
        comment.setGmtModified(getGmtModified());

        User user = new User();
        user.setId(getUserId());
        comment.setAuthor(user);

        comment.setContent(getContent());
        comment.setRefId(getRefId());
        return comment;
    }
}
