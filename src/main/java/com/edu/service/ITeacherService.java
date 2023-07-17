package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.entity.Teacher;
import com.edu.model.TeacherDTO;

import java.util.List;

/**
 * @ClassName ITeacherService
 * @Description 教师业务接口定义
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:24
 * @Version
 */

public interface ITeacherService extends IService<Teacher> {

    /**
     * 通过Id查询
     * @param id    教师Id
     * @return      查询结果
     */
    Result getById(Long id);

    /**
     * 查询所有教师信息
     * @return      查询结果
     */
    Result getAll();

    /**
     * 更新教师信息
     * @param teacher   更新数据
     * @return          更新结果
     */
    Result update(Teacher teacher);

    /**
     * 插入教师信息
     * @param teacher   插入数据
     * @return          插入结果
     */
    Result insert(Teacher teacher);

    /**
     *
     * @param ids
     * @return
     */
    Result deleteById(List<Long> ids);

    /**
     * 模糊查询
     * @param teacher 封装的DTO对象
     * @return  查询结果
     */
    Result fuzzyQuery(TeacherDTO teacher);
}
