package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Department;
import com.edu.entity.Laboratory;
import com.edu.mapper.DepartmentMapper;
import com.edu.mapper.LaboratoryMapper;
import com.edu.model.LaboratoryDTO;
import com.edu.service.IDepartmentService;
import com.edu.service.ILaboratoryService;
import com.edu.utils.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName LaboratoryServiceImpl
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:35
 * @Version
 */
@Slf4j
@Service
public class LaboratoryServiceImpl extends ServiceImpl<LaboratoryMapper, Laboratory> implements ILaboratoryService {

    @Resource
    private Map<Constants.Ids, IIdGenerator> map;

    @Resource
    private IDepartmentService departmentService;

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public Result getById(Long id) {
        Laboratory laboratory = super.getById(id);
        if (laboratory == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
        }
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), laboratory);
    }

    @Override
    public Result getAll() {
        List<Laboratory> laboratoryList = list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), laboratoryList);
    }

    @Override
    public Result update(Laboratory laboratory) {
        Long departmentId = laboratory.getDepartmentId();
        // TODO 判断是否存在对应的学院

        boolean flag = super.updateById(laboratory);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo()) :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(Laboratory laboratory) {
        Long departmentId = laboratory.getDepartmentId();
        laboratory.setId(map.get(Constants.Ids.SnowFlake).nextId());
        boolean flag = super.save(laboratory);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.INSERT_SUCCESS.getInfo()) :
                Result.buildErrorResult(Constants.OperationMessage.INSERT_FAIL.getInfo());
    }

    @Override
    public Result deleteById(List<Long> ids) {
        boolean flag = super.removeByIds(ids);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.DELETE_SUCCESS.getInfo()) :
                Result.buildErrorResult(Constants.OperationMessage.DELETE_FAIL.getInfo());
    }

    @Override
    public Result fuzzyQuery(LaboratoryDTO laboratory) {
        // 通过部门名称联表查寻
        if (null != laboratory.getDepartmentName()) {
            // 查询对应的部门ID列表
            LambdaQueryWrapper<Department> departmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            departmentLambdaQueryWrapper.like(Department::getName, laboratory.getDepartmentName());
            Department department = departmentService.getOne(departmentLambdaQueryWrapper);
            if (null == department) {
                // 字段不存在，直接返回
                return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
            }
            // 查询对应的实验室字段
            LambdaQueryWrapper<Laboratory> laboratoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
            laboratoryLambdaQueryWrapper.eq(Laboratory::getDepartmentId, department.getId());
            List<Laboratory> laboratoryList = super.list(laboratoryLambdaQueryWrapper);

            // 封装为DTO对象结果集
            List<LaboratoryDTO> laboratoryDTOList = new LinkedList<>();
            for(Laboratory lab : laboratoryList) {
                // 封装DTO对象
                LaboratoryDTO laboratoryDTO = new LaboratoryDTO();
                BeanUtils.copyProperties(lab, laboratoryDTO);
                laboratoryDTO.setDepartmentName(laboratory.getDepartmentName());
                // 添加列表
                laboratoryDTOList.add(laboratoryDTO);
            }

            return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), laboratoryDTOList);
        }

        // 其他条件查询拼接
        LambdaQueryWrapper<Laboratory> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(null != laboratory.getId(), Laboratory::getId, laboratory.getId());
        lambdaQueryWrapper.eq(null != laboratory.getDepartmentId(), Laboratory::getDepartmentId, laboratory.getDepartmentId());

        lambdaQueryWrapper.like(null != laboratory.getName(), Laboratory::getName, laboratory.getName());
        lambdaQueryWrapper.like(null != laboratory.getAddress(), Laboratory::getAddress, laboratory.getAddress());
        List<Laboratory> laboratoryList = super.list(lambdaQueryWrapper);

        // 封装为DTO结果集
        List<LaboratoryDTO> laboratoryDTOList = laboratoryList.stream().map((lab) -> {
            // 查询部门名称
            LambdaQueryWrapper<Department> departmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            departmentLambdaQueryWrapper.eq(Department::getId, lab.getDepartmentId());
            Department department = departmentService.getOne(departmentLambdaQueryWrapper);

            // 封装DTO信息
            LaboratoryDTO laboratoryDTO = new LaboratoryDTO();
            BeanUtils.copyProperties(lab, laboratoryDTO);
            laboratoryDTO.setDepartmentName(department.getName());

            return laboratoryDTO;
        }).collect(Collectors.toList());

        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), laboratoryDTOList);
    }


}
