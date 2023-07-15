package com.edu.model;

import lombok.Data;

/**
 * @ClassName TeacherDTO
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/15 9:10
 * @Version
 */
@Data
public class TeacherDTO {

    // 教师ID
    private Long id;

    // 教师名称
    private String name;

    // 教室性别
    private Integer gender;

    // 教室职位
    private String job;

    // 教师电话
    private String phone;

    // 教师工资
    private Long salary;

    // 教师所属部门名称
    private String departmentName;
}
