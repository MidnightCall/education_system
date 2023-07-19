package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.User;
import com.edu.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api
public class UserController {
    @Resource
    IUserService userService;

    /**
     * 登录功能
     * @param loginUser 登录参数，包含账号、密码
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@ApiParam(name = "登录数据", value = "登陆数据", required = true) @RequestBody User loginUser){
        // 实现登录功能
        return userService.login(loginUser);
    }

    /**
     * 注册功能
     * @param registerUser 注册参数，包含账号、密码
     * @return 注册结果
     */
    @PutMapping("/register")
    @ApiOperation("用户注册")
    public Result register(@ApiParam(name = "注册数据", value = "注册数据", required = true) @RequestBody User registerUser){
        return userService.register(registerUser);
    }

    /**
     * 登出功能
     * @param request HHTP请求，从中获取登录token
     * @return 登出结果
     */
    @GetMapping("/logout")
    @ApiOperation("用户登出")
    public Result logout(@ApiParam(name = "request", value = "request", required = true) HttpServletRequest request){
        return userService.logout(request.getHeader("token"));
    }
}
