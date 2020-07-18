package com.lzx.comment.service;

import com.lzx.comment.model.Result;
import com.lzx.comment.model.User;

/**
 * @InterfaceName UserService
 * @Author 刘正星
 * @Date 2020/7/16 13:26
 **/
public interface UserService {
    /**
     * 用户注册
     * @param userName
     * @param pwd
     * @return
     */
    public Result<User> register(String userName,String pwd);

    /**
     * 用户登录
     * @param userName
     * @param pwd
     * @return
     */
    public Result<User> login(String userName,String pwd);
}
