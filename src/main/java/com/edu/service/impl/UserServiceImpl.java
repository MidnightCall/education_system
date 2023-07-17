package com.edu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.User;
import com.edu.mapper.UserMapper;
import com.edu.service.IUserService;
import com.edu.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.edu.commons.Constants.LOGIN_USER_KEY;
import static com.edu.commons.Constants.LOGIN_USER_TTL;
import static com.edu.commons.Constants.ResponseCode.USERNAME_OR_PASSWORD_ERROR;

/**
 * @ClassName UserServiceImpl
 * @Description 用户业务实现
 * @Author Lucas Wang
 * @Date 2023/7/14 8:45
 * @Version
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 登录服务
     * @param loginUser 登录参数，包含用户名、密码
     * @return 登录结果
     */
    @Override
    public Result login(User loginUser) {
        // 根据用户名查询
        User user = query().eq("username", loginUser.getUsername()).one();
        // 如果用户不存在，则直接返回
        if(user == null){
            return Result.buildResult(Constants.ResponseCode.USERNAME_OR_PASSWORD_ERROR, "用户不存在！");
        }
        // 如果密码错误，则直接返回
        if(!loginUser.getPassword().equals(user.getPassword())){
            return Result.buildResult(Constants.ResponseCode.USERNAME_OR_PASSWORD_ERROR, "密码错误！");
        }

        // 保存用户信息到redis
        // 随机生成token，作为登录令牌
        String token = UUID.randomUUID().toString(true);
        // 将用户名存储在redis
        stringRedisTemplate.opsForValue().set(Constants.LOGIN_USER_KEY + token, loginUser.getUsername());
        // 设置token有效期
        stringRedisTemplate.expire(Constants.LOGIN_USER_KEY + token, LOGIN_USER_TTL, TimeUnit.MINUTES);

        //return token
        return Result.buildSuccessResult(token);
    }

    /**
     * 注册服务，并且注册成功后自动登录。因为同时涉及MySQL和redis两个数据库，所以开启事务
     * @param registerUser
     * @return 注册失败结果或登录结果
     */
    @Transactional
    @Override
    public Result register(User registerUser) {
        // 用户名长度过长或者过短时，直接返回
        int length = registerUser.getUsername().length();
        if(length < 3 || length > 15){
            return Result.buildErrorResult("用户名长度应在3-15之间！");
        }
        // 密码长度过长或者过短时，直接返回
        length = registerUser.getPassword().length();
        if(length < 6 || length > 15){
            return Result.buildErrorResult("密码长度应在6-15之间！");
        }
        // 根据用户名查询，若查询到用户，则代表用户名重复，直接返回
        User user = query().eq("username", registerUser.getUsername()).one();
        if(user != null){
            return Result.buildErrorResult("用户已存在！");
        }
        // 返回保存数据的结果
        boolean isSuccess = save(registerUser);
        if(isSuccess){
            return login(registerUser);
        }else {
            return Result.buildErrorResult("注册失败！");
        }
    }

    /**
     * 登出服务
     * @param token 用户登录时保存的token
     * @return 登出结果
     */
    @Override
    public Result logout(String token) {
        // 若本地不存在用户，则退出登录失败
        if(UserHolder.getUser() == null){
            return Result.buildErrorResult("退出登录失败！");
        }
        // 从本地移除用户
        UserHolder.removeUser();
        // 从redis中删除登录token，根据删除结果返回
        Boolean isSuccess = stringRedisTemplate.delete(LOGIN_USER_KEY + token);
        if(isSuccess){
            return Result.buildResult(Constants.ResponseCode.OK, "退出登录成功！");
        }else {
            return Result.buildErrorResult("退出登录失败！");
        }
    }
}
