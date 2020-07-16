package com.lzx.comment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Author 刘正星
 * @Date 2020/7/16 13:11
 **/
@Data
public class Result<D> implements Serializable {
    @JsonProperty("isSuccess")
    private boolean success = false;

    private String code;
    private String message;

    private D data;


}
