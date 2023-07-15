package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.*;
import com.edu.mapper.*;
import com.edu.service.*;
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

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private EquipmentMapper equipmentMapper;
    @Resource
    private LaboratoryMapper laboratoryMapper;

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
        department.setId(map.get(Constants.Ids.RedisIdWorker).nextId());
        boolean flag = super.save(department);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.INSERT_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.INSERT_FAIL.getInfo());
    }

    @Override
    public Result deleteById(List<Long> ids) {
        if(!judge(ids)){
            return Result.buildErrorResult("部门下有剩余对象存在，请将对象全部转移后再删除部门！");
        }
        boolean flag = super.removeByIds(ids);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.DELETE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.DELETE_FAIL.getInfo());
    }

    private boolean judge(List<Long> ids) {
        for (Long departmentId : ids) {
            Integer count = studentMapper.selectCount(
                    new LambdaQueryWrapper<Student>().eq(Student::getDepartmentId, departmentId));
            if(count > 0){
                return false;
            }

            count = teacherMapper.selectCount(
                    new LambdaQueryWrapper<Teacher>().eq(Teacher::getDepartmentId, departmentId));
            if(count > 0){
                return false;
            }

            count = equipmentMapper.selectCount(
                    new LambdaQueryWrapper<Equipment>().eq(Equipment::getDepartmentId, departmentId));
            if(count > 0){
                return false;
            }

            count = laboratoryMapper.selectCount(
                    new LambdaQueryWrapper<Laboratory>().eq(Laboratory::getDepartmentId, departmentId));
            if(count > 0){
                return false;
            }
        }
        return true;
    }

    public String getName(Long id){
        LambdaQueryWrapper<Department> departmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        departmentLambdaQueryWrapper.eq(Department::getId, id);
        return super.getOne(departmentLambdaQueryWrapper).getName();
    }
}
