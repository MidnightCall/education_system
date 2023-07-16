package com.edu.entity;

import lombok.Data;

/**
 * @Auther: 朱嘉诚
 * @Date: 2023/7/15 18:47
 * @Description:
 */
@Data
public class Growth {
    // 主键
    private Long id;
    // 学生id
    private String stuId;
    // 学年
    private String year;
    // 学习信息
    private String learning;
    // 学习信息
    private String research;
    // 学习信息
    private String social;
}
