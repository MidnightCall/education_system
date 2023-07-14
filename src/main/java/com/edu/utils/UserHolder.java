package com.edu.utils;

import com.edu.entity.User;

/**
 * @ClassName UserHolder
 * @Description 使用ThreadLocal保存用户登陆信息
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 9:56
 * @Version
 */

public class UserHolder {
    private static final ThreadLocal<User> tl = new ThreadLocal<>();

    public static void saveUser(User user){
        tl.set(user);
    }

    public static User getUser(){
        return tl.get();
    }

    public static void removeUser(){
        tl.remove();
    }
}

