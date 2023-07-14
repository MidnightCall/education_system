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
import static com.edu.commons.Constants.ResponseCode.USERNAME_OR_PASSWORD_ERROR;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 8:45
 * @Version
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result login(User loginUser) {
        // 根据用户名查询
        User user = query().eq("username", loginUser.getUsername()).one();
        //
        if(user == null){
            return Result.buildResult(Constants.ResponseCode.USERNAME_OR_PASSWORD_ERROR, "用户不存在！");
        }
        //
        if(!loginUser.getPassword().equals(user.getPassword())){
            return Result.buildResult(Constants.ResponseCode.USERNAME_OR_PASSWORD_ERROR, "密码错误！");
        }

        //保存用户信息到redis
        //随机生成token，作为登录令牌
        String token = UUID.randomUUID().toString(true);
        // 将用户名存储在redis
        stringRedisTemplate.opsForValue().set(Constants.LOGIN_USER_KEY + token, loginUser.getUsername());
        //设置token有效期
        stringRedisTemplate.expire(Constants.LOGIN_USER_KEY + token, 30, TimeUnit.MINUTES);

        //return token
        return Result.buildSuccessResult(token);
    }

    @Transactional
    @Override
    public Result register(User registerUser) {
        int length = registerUser.getUsername().length();
        if(length < 3 || length > 15){
            return Result.buildErrorResult("用户名长度应在3-15之间！");
        }

        length = registerUser.getPassword().length();
        if(length < 6 || length > 15){
            return Result.buildErrorResult("密码长度应在6-15之间！");
        }

        User user = query().eq("username", registerUser.getUsername()).one();
        if(user != null){
            return Result.buildErrorResult("用户已存在！");
        }

        boolean isSuccess = save(registerUser);
        if(isSuccess){
            return login(registerUser);
        }else {
            return Result.buildErrorResult("注册失败！");
        }
    }

    @Override
    public Result logout(String token) {
        String username = UserHolder.getUser().getUsername();
        UserHolder.removeUser();
        Boolean isSuccess = stringRedisTemplate.delete(LOGIN_USER_KEY + username);
        if(isSuccess){
            return Result.buildResult(Constants.ResponseCode.OK, "退出登录成功！");
        }else {
            return Result.buildErrorResult("退出登录失败！");
        }
    }
}
