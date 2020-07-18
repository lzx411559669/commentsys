package com.lzx.comment.api;

import com.lzx.comment.model.Result;
import com.lzx.comment.model.User;
import com.lzx.comment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName UserAPI
 * @Author 刘正星
 * @Date 2020/7/16 14:31
 **/
@Controller
public class UserAPI {
    @Autowired
    private UserService userService;
    @PostMapping("/api/user/reg")
    @ResponseBody
    public Result<User> register(@RequestParam("userName")String userName,@RequestParam("pwd")String pwd){

        return userService.register(userName,pwd);
    }
    @PostMapping("/api/user/login")
    @ResponseBody
    public Result<User> login(@RequestParam("userName")String userName, @RequestParam("pwd")String pwd, HttpServletRequest request, HttpServletResponse response){
        Result<User> result = userService.login(userName,pwd);

        if (result.isSuccess()){

            request.getSession().setAttribute("userId",result.getData().getId());
        }
        return result;
    }
    @GetMapping ("/api/user/logout")
    @ResponseBody
    public Result<User> logout(HttpServletRequest request){
        request.getSession().removeAttribute("userId");
        Result<User> result = new Result<>();
        result.setMessage("退出成功");
        result.setSuccess(true);
        return result;
    }

}
