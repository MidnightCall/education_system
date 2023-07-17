package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.entity.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName DepartmentMapper
 * @Description 部门仓储服务
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 20:06
 * @Version
 */

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
}
