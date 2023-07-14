package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.mapper.EquipmentMapper;
import com.edu.service.IEquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EquipmentServiceImpl
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:38
 * @Version
 */
@Slf4j
@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements IEquipmentService {
    @Override
    public Result getById(Long id) {
        Equipment equipment = super.getById(id);
        if (equipment == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
        }
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), equipment);
    }

    @Override
    public Result getAll() {
        List<Equipment> equipmentList = super.list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), equipmentList);
    }

    @Override
    public Result update(Equipment equipment) {

        return null;
    }

    @Override
    public Result insert(Equipment equipment) {
        return null;
    }

    @Override
    public Result deleteById(Long id) {
        return null;
    }

    @Override
    public Result delete(List<Long> ids) {
        return null;
    }
}
