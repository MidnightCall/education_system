package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Department;
import com.edu.entity.Equipment;
import com.edu.mapper.EquipmentMapper;
import com.edu.model.EquipmentDTO;
import com.edu.service.IDepartmentService;
import com.edu.service.IEquipmentService;
import com.edu.service.ILaboratoryService;
import com.edu.utils.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Resource
    private Map<Constants.Ids, IIdGenerator> map;

    @Resource
    private IDepartmentService departmentService;

    @Override
    public Result getById(Long id) {
        Equipment equipment = super.getById(id);
        if (equipment == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
        }

        // 查询对应的部门名称
        Department department = departmentService.getById(equipment.getDepartmentId());

        EquipmentDTO equipmentDTO = new EquipmentDTO();
        BeanUtils.copyProperties(equipment, equipmentDTO);
        equipmentDTO.setDepartmentName(department.getName());

        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), equipmentDTO);
    }

    @Override
    public Result getAll() {
        List<Equipment> equipmentList = super.list();

        // 封装为DTO结果集
        List<EquipmentDTO> equipmentDTOList = equipmentList.stream().map((equipment -> {
            // 查询部门名称
            Department department = departmentService.getById(equipment.getDepartmentId());
            // 封装DTO
            EquipmentDTO equipmentDTO = new EquipmentDTO();
            BeanUtils.copyProperties(equipment, equipmentDTO);
            equipmentDTO.setDepartmentName(department.getName());
            return equipmentDTO;
        })).collect(Collectors.toList());

        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), equipmentDTOList);
    }

    @Override
    public Result update(Equipment equipment) {
//        if(!departmentIsExists(equipment.getDepartmentId())){
//            return Result.buildErrorResult("设备所属的实验室不存在");
//        }
        boolean flag = super.updateById(equipment);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo()) :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(Equipment equipment) {
//        if(!departmentIsExists(equipment.getDepartmentId())){
//            return Result.buildErrorResult("设备所属的实验室不存在");
//        }
        equipment.setId(map.get(Constants.Ids.ShortCode).nextId());
        boolean flag = super.save(equipment);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.INSERT_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.INSERT_FAIL.getInfo());
    }

    @Override
    public Result deleteById(List<Long> ids) {
        boolean flag = super.removeByIds(ids);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.DELETE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.DELETE_FAIL.getInfo());
    }

    /**
     * 辅助方法，判断部门ID(外键是否存在)
     * @param departmentId 部门ID
     * @return      是否存在
     */
    private boolean departmentIsExists(Long departmentId) {
        return null != departmentService.getById(departmentId);
    }
}
