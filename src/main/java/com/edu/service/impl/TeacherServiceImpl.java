package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Department;
import com.edu.entity.Equipment;
import com.edu.entity.Teacher;
import com.edu.mapper.EquipmentMapper;
import com.edu.mapper.TeacherMapper;
import com.edu.model.StudentDTO;
import com.edu.model.TeacherDTO;
import com.edu.service.IDepartmentService;
import com.edu.service.IEquipmentService;
import com.edu.service.ITeacherService;
import com.edu.utils.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Override
    public Result getById(Long id) {
        Teacher teacher = super.getById(id);
        if (teacher == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo() + ", 不存在的TeacherID");
        }

        // 查询对应的部门名称
        Department department = departmentService.getById(teacher.getDepartmentId());

        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        teacherDTO.setDepartmentName(department.getName());
        
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), teacherDTO);
    }

    @Override
    public Result getAll() {
        List<Teacher> teacherList = list();

        // 封装为DTO结果集
        List<TeacherDTO> teacherDTOList = teacherList.stream().map((teacher -> {
            // 查询部门名称
            Department department = departmentService.getById(teacher.getDepartmentId());
            // 封装DTO
            TeacherDTO teacherDTO = new TeacherDTO();
            BeanUtils.copyProperties(teacher, teacherDTO);
            teacherDTO.setDepartmentName(department.getName());
            return teacherDTO;
        })).collect(Collectors.toList());
        
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), teacherList);
    }

    @Override
    public Result update(Teacher teacher) {
        if(!judge(teacher)){
            // 是否存在非空字段
            return Result.buildErrorResult(Constants.OperationMessage.NULL_ERROR.getInfo());
        }
//        if(!departmentIsExists(teacher.getDepartmentId())) {
//            // 外键是否合法
//            return Result.buildErrorResult(Constants.OperationMessage.DEPART_NOT_EXIST.getInfo());
//        }
        boolean flag = super.updateById(teacher);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(Teacher teacher) {
        if(!judge(teacher)) {
            // 是否存在非空字段
            return Result.buildErrorResult(Constants.OperationMessage.NULL_ERROR.getInfo());
        }
//        if(!departmentIsExists(teacher.getDepartmentId())) {
//            // 外键是否合法
//            return Result.buildErrorResult(Constants.OperationMessage.DEPART_NOT_EXIST.getInfo());
//        }
        teacher.setId(map.get(Constants.Ids.ShortCode).nextId());
        boolean flag = super.save(teacher);
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
     * 判断给定数据是否合法
     * @return 判断结果
     */
    private boolean judge(Teacher teacher){
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
