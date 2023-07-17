package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.Department;

import java.util.List;

/**
 * @ClassName IDepartmentService
 * @Description 部门业务接口定义
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:24
 * @Version
 */

public interface IDepartmentService extends IService<Department> {
    Result queryById(Long id);

    Result queryAll();

    Result update(Department department);

    Result insert(Department department);

    Result deleteById(List<Long> ids);
}
