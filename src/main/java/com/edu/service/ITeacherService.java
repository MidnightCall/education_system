package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.entity.Teacher;

import java.util.List;

/**
 * @ClassName ITeacherService
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:24
 * @Version
 */

public interface ITeacherService extends IService<Teacher> {
    Result getById(Long id);

    Result getAll();

    Result update(Teacher teacher);

    Result insert(Teacher teacher);

    Result deleteById(List<Long> ids);
}
