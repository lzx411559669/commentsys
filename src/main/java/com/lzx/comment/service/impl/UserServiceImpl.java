package com.lzx.comment.service.impl;

import com.lzx.comment.service.UserService;
import com.lzx.comment.dao.UserDAO;
import com.lzx.comment.dataobject.UserDO;
import com.lzx.comment.model.Result;
import com.lzx.comment.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Author 刘正星
 * @Date 2020/7/16 13:32
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public Result<User> register(String userName, String pwd) {
        Result<User> result = new Result<>();
        //这段逻辑推荐只用if，if-else多层嵌套阅读性很差。
        //用户名为空
        if (StringUtils.isEmpty(userName)){
            result.setCode("600");
            result.setMessage("用户名不能为空！");
        }else{
            //用户名不为空，密码为空
            if (StringUtils.isEmpty(pwd)){
                result.setCode("601");
                result.setMessage("密码不能为空");
            }else {
                //用户名不为空，密码不为空
                //判断用户是否存在
                UserDO userDO = userDAO.findByUserName(userName);
                //用户不存在
                if (userDO == null){
                    String saltPwd = pwd+"_lzx0203";
                    String md5Pwd = DigestUtils.md5Hex(saltPwd).toUpperCase();
                    userDO = new UserDO();
                    userDO.setUserName(userName);
                    userDO.setNickName(userName);
                    userDO.setPwd(md5Pwd);
                    //储存用户记录
                    userDAO.add(userDO);
                    result.setSuccess(true);
                    //将 UserDO 对象转化为 User 对象
                    User user = new User();
                    user.setId(userDO.getId());
                    user.setUserName(userDO.getUserName());
                    user.setNickName(userDO.getNickName());

                    result.setData(user);
                }else{
                    //用户名已经存在
                    result.setCode("602");
                    result.setMessage("用户名已经存在");
                }
            }
        }
        return result;
    }
}
