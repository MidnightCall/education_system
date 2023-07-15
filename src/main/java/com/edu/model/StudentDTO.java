package com.edu.model;

import lombok.Data;

/**
 * @ClassName StudentDTO
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/15 9:17
 * @Version
 */
@Data
public class StudentDTO {

    // 学生ID
    private String id;

    // 学生姓名
    private String name;

    // 学生性别
    private Integer gender;

    // 学生手机
    private String phone;

    // 学生年级
    private String grade;

    // 学生班级
    private String clazz;

    // 学生宿舍
    private String dormitory;

    // 部门名称
    private String departmentName;
}
