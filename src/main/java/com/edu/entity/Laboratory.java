package com.edu.entity;

import lombok.Data;

/**
 * @ClassName Laboratory
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 14:55
 * @Version
 */

@Data
public class Laboratory {
    // 主键Id
    private Long id;
    // 实验室名称
    private String name;
    // 地址
    private String address;
    // 学院Id
    private Long departmentId;
}
