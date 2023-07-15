package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.User;

import javax.servlet.http.HttpSession;

/**
 * @ClassName IUserService
 * @Description 用户业务接口定义
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 8:45
 * @Version
 */

public interface IUserService extends IService<User> {

    /**
     * 登录业务
     * @param loginUser 登录用户封装类
     * @return          登录结果
     */
    Result login(User loginUser);

    /**
     * 注册业务
     * @param registerUser 注册用户封装类
     * @return             注册结果
     */
    Result register(User registerUser);

    /**
     * 登出业务
     * @param token 登出令牌
     * @return      结果
     */
    Result logout(String token);
}
