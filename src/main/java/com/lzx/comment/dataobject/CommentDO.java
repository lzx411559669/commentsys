package com.lzx.comment.dataobject;

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

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}
