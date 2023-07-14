package com.edu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 8:44
 * @Version
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 用户名
     */
    @TableId(value = "username")
    private String username;

    /**
     * 密码，加密存储
     */
    private String password;
}
