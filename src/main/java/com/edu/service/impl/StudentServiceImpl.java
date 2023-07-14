package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.entity.Student;
import com.edu.entity.Teacher;
import com.edu.mapper.EquipmentMapper;
import com.edu.mapper.StudentMapper;
import com.edu.service.IEquipmentService;
import com.edu.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public Result getById(Long id) {
        Student student = super.getById(id);
        if (student == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
        }
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), student);
    }

    @Override
    public Result getAll() {
        return null;
    }

    @Override
    public Result update(Student student) {
        return null;
    }

    @Override
    public Result insert(Student student) {
        return null;
    }

    @Override
    public Result deleteById(List<Long> id) {
        return null;
    }
}
