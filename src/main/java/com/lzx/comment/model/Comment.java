package com.lzx.comment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName Comment
 * @Author 刘正星
 * @Date 2020/7/16 12:57
 **/
@Data
public class Comment {
    private long id;
    private String refId;
    private User author;
    private String content;
    private long parentId;
    private List<Comment> children;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;

}
