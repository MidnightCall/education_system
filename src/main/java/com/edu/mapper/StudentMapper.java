package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName StudentMapper
 * @Description 学生仓储服务
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:24
 * @Version
 */

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
