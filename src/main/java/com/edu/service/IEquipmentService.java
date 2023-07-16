package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.mapper.EquipmentMapper;
import com.edu.model.EquipmentDTO;
import com.edu.model.LaboratoryDTO;

import java.util.List;

/**
 * @ClassName IEquipmentService
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:35
 * @Version
 */

public interface IEquipmentService extends IService<Equipment> {

    /**
     * 查单个
     * @param id
     * @return
     */
    Result getById(Long id);

    /**
     * 查全部
     * @return
     */
    Result getAll();

    Result update(Equipment equipment);

    Result insert(Equipment equipment);

    Result deleteById(List<Long> ids);

    /**
     * 模糊查询接口
     * @param equipment 设备装类
     * @return           查询结果
     */
    Result fuzzyQuery(EquipmentDTO equipment);
}
