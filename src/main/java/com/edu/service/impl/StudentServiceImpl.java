package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.*;
import com.edu.mapper.EquipmentMapper;
import com.edu.mapper.StudentMapper;
import com.edu.model.EquipmentDTO;
import com.edu.model.LaboratoryDTO;
import com.edu.model.StudentDTO;
import com.edu.service.IDepartmentService;
import com.edu.service.IEquipmentService;
import com.edu.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StudentServiceImpl
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:24
 * @Version
 */
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    private IDepartmentService departmentService;

    @Override
    public Result getById(Long id) {
        Student student = super.getById(id);
        // 学生不存在，则返回失败结果
        if (student == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
        }

        // 查询对应的部门名称
        Department department = departmentService.getById(student.getDepartmentId());
        // 封装成DTO
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        studentDTO.setDepartmentName(department.getName());
        // 返回DTO
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), studentDTO);
    }

    @Override
    public Result getAll() {
        List<Student> studentList = super.list();

        // 封装为DTO结果集
        List<StudentDTO> studentDTOList = studentList.stream().map((student -> {
            // 查询部门名称
            Department department = departmentService.getById(student.getDepartmentId());
            // 封装DTO
            StudentDTO studentDTO = new StudentDTO();
            BeanUtils.copyProperties(student, studentDTO);
            studentDTO.setDepartmentName(department.getName());
            return studentDTO;
        })).collect(Collectors.toList());
        
        return Result.buildResult(Constants.ResponseCode.OK, Constants.ResponseCode.OK.getInfo(), studentDTOList);
    }

    @Override
    public Result update(Student student) {
        if(!judge(student)) {
            // 是否存在不合法的非空字段
            return Result.buildErrorResult(Constants.OperationMessage.NULL_ERROR.getInfo());
        }
        if(!departmentIsExists(student.getDepartmentId())){
            // 检查外键
            return Result.buildErrorResult(Constants.OperationMessage.DEPART_NOT_EXIST.getInfo());
        }
        boolean flag = super.updateById(student);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo()) :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(Student student) {
        if(!judge(student)) {
            // 是否存在不合法的非空字段
            return Result.buildErrorResult(Constants.OperationMessage.NULL_ERROR.getInfo());
        }
        if(!departmentIsExists(student.getDepartmentId())){
            // 检查外键
            return Result.buildErrorResult(Constants.OperationMessage.DEPART_NOT_EXIST.getInfo());
        }
        boolean flag = super.save(student);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.INSERT_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.INSERT_FAIL.getInfo());
    }

    @Override
    public Result deleteById(List<Long> ids) {
        // 批量删除
        boolean flag = super.removeByIds(ids);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.DELETE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.DELETE_FAIL.getInfo());
    }

    @Override
    public Result fuzzyQuery(StudentDTO student) {
        // 通过部门名称联表查寻
        if (null != student.getDepartmentName()) {
            // 查询对应的部门ID列表
            LambdaQueryWrapper<Department> departmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            departmentLambdaQueryWrapper.like(Department::getName, student.getDepartmentName());
            List<Department> departmentList = departmentService.list(departmentLambdaQueryWrapper);
            if (0 == departmentList.size()) {
                // 字段不存在，直接返回
                return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
            }

            // 查询对应的实验室字段
            List<StudentDTO> studentDTOList = new LinkedList<>();
            for(Department department : departmentList) {
                LambdaQueryWrapper<Student> studentLambdaQueryWrapper = new LambdaQueryWrapper<>();
                studentLambdaQueryWrapper.eq(Student::getDepartmentId, department.getId());
                List<Student> studentList = super.list(studentLambdaQueryWrapper);
                // 封装为DTO对象
                List<StudentDTO> tempDtoList = studentList.stream().map(lab -> {
                    StudentDTO studentDTO = new StudentDTO();
                    BeanUtils.copyProperties(lab, studentDTO);
                    studentDTO.setDepartmentName(department.getName());
                    return studentDTO;
                }).collect(Collectors.toList());
                studentDTOList.addAll(tempDtoList);
            }

            return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), studentDTOList);
        }

        // 其他条件查询拼接
        LambdaQueryWrapper<Student> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(null != student.getId(), Student::getId, student.getId());
        lambdaQueryWrapper.eq(null != student.getDepartmentId(), Student::getDepartmentId, student.getDepartmentId());
        lambdaQueryWrapper.eq(null != student.getGender(), Student::getGender, student.getGender());

        lambdaQueryWrapper.like(null != student.getName(), Student::getName, student.getName());
        lambdaQueryWrapper.like(null != student.getClazz(), Student::getClazz, student.getClazz());
        lambdaQueryWrapper.like(null != student.getDormitory(), Student::getDormitory, student.getDormitory());
        lambdaQueryWrapper.like(null != student.getGrade(), Student::getGrade, student.getGrade());
        lambdaQueryWrapper.like(null != student.getPhone(), Student::getPhone, student.getPhone());

        List<Student> studentList = super.list(lambdaQueryWrapper);

        // 封装为DTO结果集
        List<StudentDTO> studentDTOList = studentList.stream().map((lab) -> {
            // 查询部门名称
            LambdaQueryWrapper<Department> departmentLambdaQueryWrapper = new LambdaQueryWrapper<>();
            departmentLambdaQueryWrapper.eq(Department::getId, lab.getDepartmentId());
            Department department = departmentService.getOne(departmentLambdaQueryWrapper);

            // 封装DTO信息
            StudentDTO studentDTO = new StudentDTO();
            BeanUtils.copyProperties(lab, studentDTO);
            studentDTO.setDepartmentName(department.getName());

            return studentDTO;
        }).collect(Collectors.toList());

        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), studentDTOList);
    }

    /**
     * 判断给定数据是否合法
     * @param student   学生
     * @return          结果
     */
    private boolean judge(Student student) {
        String name = student.getName();
        Long departmentId = student.getDepartmentId();
        return null != name && departmentId != null;
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
