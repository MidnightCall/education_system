package com.edu.model;

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
public class StudentDTO extends Student {

    // 部门名称
    private String departmentName;
}
