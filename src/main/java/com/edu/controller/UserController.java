package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.User;
import com.edu.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName UserController
 * @Description
 * @Author Lucas Wang
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

    /**
     * 注册功能
     * @param registerUser 注册参数，包含账号、密码
     * @return 注册结果
     */
    @PutMapping("/register")
    public Result register(@RequestBody User registerUser){
        return userService.register(registerUser);
    }

    /**
     * 登出功能
     * @param request HHTP请求，从中获取登录token
     * @return 登出结果
     */
    @GetMapping("/logout")
    public Result logout(HttpServletRequest request){
        return userService.logout(request.getHeader("token"));
    }
}
