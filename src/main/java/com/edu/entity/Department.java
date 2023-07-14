package com.edu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName Department
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 20:06
 * @Version
 */

@Data
@TableName("department")
public class Department {
    @TableId("id")
    private Long id;

    private String name;

    private String address;
}
