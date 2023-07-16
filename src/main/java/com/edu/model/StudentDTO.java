package com.edu.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.edu.entity.Student;
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

    // 主键Id
    private Long id;

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

    // 部门名称
    private String departmentName;
}
