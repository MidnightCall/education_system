package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Department;
import com.edu.entity.Equipment;
import com.edu.entity.Laboratory;
import com.edu.mapper.EquipmentMapper;
import com.edu.model.EquipmentDTO;
import com.edu.model.LaboratoryDTO;
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
        if(!departmentIsExists(equipment.getDepartmentId())){
            return Result.buildErrorResult(Constants.OperationMessage.DEPART_NOT_EXIST.getInfo());
        }
        boolean flag = super.updateById(equipment);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo()) :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(Equipment equipment) {
        if(!departmentIsExists(equipment.getDepartmentId())){
            return Result.buildErrorResult(Constants.OperationMessage.DEPART_NOT_EXIST.getInfo());
        }
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

    @Override
    public Result fuzzyQuery(EquipmentDTO equipment) {
        // 通过部门名称联表查寻
        if (null != equipment.getDepartmentName()) {
            // 查询对应的部门ID列表
            LambdaQueryWrapper<Department> departmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            departmentLambdaQueryWrapper.like(Department::getName, equipment.getDepartmentName());
            Department department = departmentService.getOne(departmentLambdaQueryWrapper);
            if (null == department) {
                // 字段不存在，直接返回
                return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
            }
            // 查询对应的实验室字段
            LambdaQueryWrapper<Equipment> equipmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            equipmentLambdaQueryWrapper.eq(Equipment::getDepartmentId, department.getId());
            List<Equipment> equipmentList = super.list(equipmentLambdaQueryWrapper);

            // 封装为DTO对象结果集
            List<EquipmentDTO> equipmentDTOList = equipmentList.stream().map(equip -> {
                EquipmentDTO equipmentDTO = new EquipmentDTO();
                BeanUtils.copyProperties(equip, equipmentDTO);
                equipmentDTO.setDepartmentName(equipment.getDepartmentName());
                return equipmentDTO;
            }).collect(Collectors.toList());

            return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), equipmentDTOList);
        }

        // 其他条件查询拼接
        LambdaQueryWrapper<Equipment> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(null != equipment.getId(), Equipment::getId, equipment.getId());
        lambdaQueryWrapper.eq(null != equipment.getDepartmentId(), Equipment::getDepartmentId, equipment.getDepartmentId());
        lambdaQueryWrapper.eq(null != equipment.getPrice(), Equipment::getPrice, equipment.getPrice());

        lambdaQueryWrapper.like(null != equipment.getName(), Equipment::getName, equipment.getName());
        lambdaQueryWrapper.like(null != equipment.getDescription(), Equipment::getDescription, equipment.getDescription());
        lambdaQueryWrapper.like(null != equipment.getType(), Equipment::getType, equipment.getType());

        List<Equipment> equipmentList = super.list(lambdaQueryWrapper);

        // 封装为DTO结果集
        List<EquipmentDTO> equipmentDTOList = equipmentList.stream().map((lab) -> {
            // 查询部门名称
            LambdaQueryWrapper<Department> departmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            departmentLambdaQueryWrapper.eq(Department::getId, lab.getDepartmentId());
            Department department = departmentService.getOne(departmentLambdaQueryWrapper);

            // 封装DTO信息
            EquipmentDTO equipmentDTO = new EquipmentDTO();
            BeanUtils.copyProperties(lab, equipmentDTO);
            equipmentDTO.setDepartmentName(department.getName());

            return equipmentDTO;
        }).collect(Collectors.toList());

        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), equipmentDTOList);
    }

    /**
     * 判断外键是否合法
     * @param departmentId  部门ID
     * @return              判断结果
     */
    public boolean departmentIsExists(Long departmentId) {
        return null != departmentService.getById(departmentId);
    }
}
