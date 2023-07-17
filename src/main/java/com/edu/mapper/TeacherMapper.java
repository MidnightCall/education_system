package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName TeacherMapper
 * @Description 教师仓储服务
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:24
 * @Version
 */

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
}
