package com.edu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName Teacher
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:23
 * @Version
 */

@Data
@TableName("teacher")
public class Teacher {
    // 主键Id
    private Long id;

    // 姓名
    private String name;

    // 性别：0-男，1-女，默认为男
    private Integer gender;

    // 所属部门
    private String department;

    // 职称
    private String job;

    // 手机号
    private String phone;

    // 工资
    private Long salary;
}
