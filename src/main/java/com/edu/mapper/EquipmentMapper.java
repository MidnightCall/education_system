package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName EquipmentMapper
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:36
 * @Version
 */

@Mapper
public interface EquipmentMapper extends BaseMapper<Equipment> {
}
