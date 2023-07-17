package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.entity.Student;
import com.edu.model.StudentDTO;

import java.util.List;

/**
 * @ClassName IStudentService
 * @Description 学生业务接口定义
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:24
 * @Version
 */

public interface IStudentService extends IService<Student> {
    /**
     * 查单个，回显
     * @param id
     * @return
     */
    Result getById(Long id);

    /**
     * 查全部
     * @return
     */
    Result getAll();

    /**
     * 更新
     * @param student
     * @return
     */
    Result update(Student student);

    /**
     * 插入
     * @param student
     * @return
     */
    Result insert(Student student);

    /**
     * 删除
     * @param id
     * @return
     */
    Result deleteById(List<Long> id);

    /**
     * 模糊查询接口
     * @param studentDTO 实验室封装类
     * @return           查询结果
     */
    Result fuzzyQuery(StudentDTO studentDTO);
}
