package com.lzx.comment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Author 刘正星
 * @Date 2020/7/16 12:52
 **/
@Data
public class User {
    private long id;
    private String userName;
    @JsonSerialize(using = NullSerializer.class)
    private String pwd;
    private String nickName;
    private String avatar;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;
}
