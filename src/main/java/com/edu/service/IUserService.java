package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.User;

import javax.servlet.http.HttpSession;

/**
 * @ClassName IUserService
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 8:45
 * @Version
 */

public interface IUserService extends IService<User> {

    Result login(User loginUser);

    Result register(User registerUser);

    Result logout();
}
