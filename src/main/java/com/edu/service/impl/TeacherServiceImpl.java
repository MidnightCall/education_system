package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.entity.Teacher;
import com.edu.mapper.EquipmentMapper;
import com.edu.mapper.TeacherMapper;
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

    @Override
    public Result getById(Long id) {
        Teacher teacher = super.getById(id);
        if (teacher == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo() + ", 不存在的TeacherID");
        }
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), teacher);
    }

    @Override
    public Result getAll() {
        List<Teacher> teacherList = list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), teacherList);
    }

    @Override
    public Result update(Teacher teacher) {
        boolean flag = super.updateById(teacher);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(Teacher teacher) {
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
}
