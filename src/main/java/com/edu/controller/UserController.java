package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.User;
import com.edu.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 8:45
 * @Version
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    IUserService userService;

    /**
     * 登录功能
     * @param loginUser 登录参数，包含账号、密码
     */
    @PostMapping("/login")
    public Result login(@RequestBody User loginUser){
        // 实现登录功能
        return userService.login(loginUser);
    }

    @PutMapping("/register")
    public Result register(@RequestBody User registerUser){
        return userService.register(registerUser);
    }

    @GetMapping("/logout")
    public Result logout(){
        return userService.logout();
    }
}
