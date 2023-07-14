package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.mapper.EquipmentMapper;

import java.util.List;

/**
 * @ClassName IEquipmentService
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:35
 * @Version
 */

public interface IEquipmentService extends IService<Equipment> {
    
    Result getById(Long id);

    Result getAll();

    Result update(Equipment equipment);

    Result insert(Equipment equipment);

    Result deleteById(Long id);

    Result delete(List<Long> ids);
}
