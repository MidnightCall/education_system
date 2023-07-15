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
 * @Author Lucas Wang
 * @Date 2023/7/13 20:07
 * @Version
 */
@Slf4j
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Resource
    private Map<Constants.Ids, IIdGenerator> map;

    // 获取Student、Teacher、Equipment、Laboratory四个mapper的bean
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private EquipmentMapper equipmentMapper;
    @Resource
    private LaboratoryMapper laboratoryMapper;

    /**
     * 查询单个部门服务
     * @param id 部门id
     * @return 查询结果
     */
    @Override
    public Result queryById(Long id) {
        // 根据id查询部门
        Department department = super.getById(id);
        // 若没查询到部门，则返回失败结果
        if(department == null){
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo() + ", 不存在的部门ID");
        }
        // 返回查询结果
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), department);

    }

    /**
     * 查询所有部门服务
     * @return 所有部门的列表
     */
    @Override
    public Result queryAll() {
        // 查询所有部门的列表并且返回
        List<Department> departments = list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), departments);
    }

    /**
     * 更新部门服务
     * @param department 更新部门的新名字、地址
     * @return 更新结果
     */
    @Override
    public Result update(Department department) {
        // 根据id查询部门
        Long id = department.getId();
        Integer count = query().eq("id", id).count();
        // 如果该部门不存在，则返回失败结果
        if(count.intValue() < 1){
            return Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
        }
        // 查看新的部门名字，若名字为空，则返回失败结果
        String name = department.getName();
        if(name == null || name.isEmpty()){
            return Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
        }
        // 根据更新结果返回
        boolean flag = super.updateById(department);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    /**
     * 新增部门服务
     * @param department 新部门的参数，包含名字、地址
     * @return 新增结果
     */
    @Override
    public Result insert(Department department) {
        // 查看部门名字，若名字为空，则返回失败结果
        String name = department.getName();
        if(name == null || name.isEmpty()){
            return Result.buildErrorResult(Constants.OperationMessage.INSERT_FAIL.getInfo());
        }
        // 采用reids自增策略生成部门id
        department.setId(map.get(Constants.Ids.RedisIdWorker).nextId());
        // 根据保存结果返回新增结果
        boolean flag = super.save(department);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.INSERT_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.INSERT_FAIL.getInfo());
    }

    /**
     * 批量删除部门服务
     * @param ids 需要被删除的部门id列表
     * @return 删除结果
     */
    @Override
    public Result deleteById(List<Long> ids) {
        // 若某个部门之下有剩余的对象，则返回删除失败
        if(!judge(ids)){
            return Result.buildErrorResult("部门下有剩余对象存在，请将对象全部转移后再删除部门！");
        }
        // 根据批量删除结果返回
        boolean flag = super.removeByIds(ids);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.DELETE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.DELETE_FAIL.getInfo());
    }

    /**
     * 判断是否所有的部门都可以被删除
     * @param ids 需要被删除的部门id列表
     * @return 判断结果，false为不可以删除，true为可以删除
     */
    private boolean judge(List<Long> ids) {
        // 对每个部门进行判断
        for (Long departmentId : ids) {
            // 若还有学生属于该部门，则返回false
            Integer count = studentMapper.selectCount(
                    new LambdaQueryWrapper<Student>().eq(Student::getDepartmentId, departmentId));
            if(count > 0){
                return false;
            }
            // 若还有教师属于该部门，则返回false
            count = teacherMapper.selectCount(
                    new LambdaQueryWrapper<Teacher>().eq(Teacher::getDepartmentId, departmentId));
            if(count > 0){
                return false;
            }
            // 若还有设备属于该部门，则返回false
            count = equipmentMapper.selectCount(
                    new LambdaQueryWrapper<Equipment>().eq(Equipment::getDepartmentId, departmentId));
            if(count > 0){
                return false;
            }
            // 若还有实验室属于该部门，则返回false
            count = laboratoryMapper.selectCount(
                    new LambdaQueryWrapper<Laboratory>().eq(Laboratory::getDepartmentId, departmentId));
            if(count > 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 根据部门id获得部门名字
     * @param id 部门id
     * @return 对应部门的名字
     */
    public String getName(Long id){
        LambdaQueryWrapper<Department> departmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        departmentLambdaQueryWrapper.eq(Department::getId, id);
        return super.getOne(departmentLambdaQueryWrapper).getName();
    }
}
