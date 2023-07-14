package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Department;
import com.edu.entity.Equipment;
import com.edu.entity.Teacher;
import com.edu.mapper.DepartmentMapper;
import com.edu.mapper.EquipmentMapper;
import com.edu.service.IDepartmentService;
import com.edu.service.IEquipmentService;
import com.edu.utils.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DepartmentServiceImpl
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 20:07
 * @Version
 */
@Slf4j
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Resource
    private Map<Constants.Ids, IIdGenerator> map;

    @Override
    public Result queryById(Long id) {
        Department department = super.getById(id);
        if(department == null){
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo() + ", 不存在的部门ID");
        }
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), department);

    }

    @Override
    public Result queryAll() {
        List<Department> departments = list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), departments);
    }

    @Override
    public Result update(Department department) {
        Long id = department.getId();
        Integer count = query().eq("id", id).count();
        if(count.intValue() < 1){
            return Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
        }

        String name = department.getName();
        if(name == null || name.isEmpty()){
            return Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
        }

        boolean flag = super.updateById(department);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(Department department) {
        String name = department.getName();
        if(name == null || name.isEmpty()){
            return Result.buildErrorResult(Constants.OperationMessage.INSERT_FAIL.getInfo());
        }
        department.setId(map.get(Constants.Ids.RandomNumeric).nextId());
        boolean flag = super.save(department);
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
}
