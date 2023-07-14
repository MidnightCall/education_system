package com.edu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @ClassName Student
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:23
 * @Version
 */

@Data
public class Student {
    // 主键Id
    private String id;

    // 学生姓名
    private String name;

    // 性别: 0-男，1-女，默认为男
    private Integer gender;

    // 手机号
    private String phone;

    // 归属机构（学院）
    private Long departmentId;

    // 年级
    private String grade;

    // 班级
    @TableField("class")
    private String clazz;

    // 宿舍
    private String dormitory;
}
