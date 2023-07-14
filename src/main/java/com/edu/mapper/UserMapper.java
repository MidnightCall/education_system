package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 8:46
 * @Version
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
