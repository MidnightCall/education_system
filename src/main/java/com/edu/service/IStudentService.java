package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.entity.Student;

import java.util.List;

/**
 * @ClassName IStudentService
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:24
 * @Version
 */

public interface IStudentService extends IService<Student> {
    Result getById(Long id);

    Result getAll();

    Result update(Student student);

    Result insert(Student student);

    Result deleteById(List<Long> id);
}
