package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.entity.Laboratory;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName LaboratoryMapper
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:36
 * @Version
 */

@Mapper
public interface LaboratoryMapper extends BaseMapper<Laboratory> {
}
