package com.edu.model;

import com.edu.entity.Teacher;
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
    // 主键Id
    private Long id;

    // 姓名
    private String name;

    // 性别：0-男，1-女，默认为男
    private Integer gender;

    // 归属机构（学院）
    private Long departmentId;

    // 职称
    private String job;

    // 手机号
    private String phone;

    // 工资
    private Long salary;

    // 教师所属部门名称
    private String departmentName;
}
