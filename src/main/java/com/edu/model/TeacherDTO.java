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
public class TeacherDTO extends Teacher {

    // 教师所属部门名称
    private String departmentName;
}
