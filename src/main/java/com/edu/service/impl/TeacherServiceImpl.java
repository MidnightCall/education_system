package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.entity.Teacher;
import com.edu.mapper.EquipmentMapper;
import com.edu.mapper.TeacherMapper;
import com.edu.service.IDepartmentService;
import com.edu.service.IEquipmentService;
import com.edu.service.ITeacherService;
import com.edu.utils.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TeacherServiceImpl
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:24
 * @Version
 */
@Slf4j
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Resource
    private Map<Constants.Ids, IIdGenerator> map;

    @Resource
    private IDepartmentService departmentService;

    /**
     * 查询单个教师服务
     * @param id    教师Id
     * @return 查询结果
     */
    @Override
    public Result getById(Long id) {
        // 根据id查询教师
        Teacher teacher = super.getById(id);
        // 若教师不存在，则返回失败结果
        if (teacher == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo() + ", 不存在的TeacherID");
        }
        // 返回查询结果
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), teacher);
    }

    /**
     * 查询所有教师服务
     * @return 所有教师的列表
     */
    @Override
    public Result getAll() {
        List<Teacher> teacherList = list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), teacherList);
    }

    /**
     * 更新教师服务
     * @param teacher   更新数据
     * @return 更新结果
     */
    @Override
    public Result update(Teacher teacher) {
        if(!judge(teacher)){
            // 是否存在非空字段
            return Result.buildErrorResult(Constants.OperationMessage.NULL_ERROR.getInfo());
        }
        //if(!departmentIsExists(teacher.getDepartmentId())) {
        //    // 外键是否合法
        //    return Result.buildErrorResult(Constants.OperationMessage.DEPART_NOT_EXIST.getInfo());
        //}
        //根据更新结果返回
        boolean flag = super.updateById(teacher);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    /**
     * 新增教师服务
     * @param teacher   插入数据
     * @return 新增结果
     */
    @Override
    public Result insert(Teacher teacher) {
        if(!judge(teacher)) {
            // 是否存在非空字段
            return Result.buildErrorResult(Constants.OperationMessage.NULL_ERROR.getInfo());
        }
        //if(!departmentIsExists(teacher.getDepartmentId())) {
        //    // 外键是否合法
        //    return Result.buildErrorResult(Constants.OperationMessage.DEPART_NOT_EXIST.getInfo());
        //}
        teacher.setId(map.get(Constants.Ids.ShortCode).nextId());
        boolean flag = super.save(teacher);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.INSERT_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.INSERT_FAIL.getInfo());
    }

    /**
     * 删除教师服务
     * @param ids
     * @return 删除结果
     */
    @Override
    public Result deleteById(List<Long> ids) {
        boolean flag = super.removeByIds(ids);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.DELETE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.DELETE_FAIL.getInfo());
    }

    /**
     * 判断给定数据是否合法
     * @return 判断结果
     */
    private boolean judge(Teacher teacher){
        // 若教师的名字或部门id为空，则返回false
        String name = teacher.getName();
        Long departmentId = teacher.getDepartmentId();
        return null != name && null != departmentId;
    }

    /**
     * 查询外键是否存在
     * @param departmentId  部门ID
     * @return              是否存在
     */
    public boolean departmentIsExists(Long departmentId) {
        return null != departmentService.getById(departmentId);
    }
}
