package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.mapper.LaboratoryMapper;
import com.edu.service.ILaboratoryService;
import com.edu.utils.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
        Long teacherId = laboratory.getTeacherId();
        // TODO 判断是否存在对应的学院和管理老师

        boolean flag = super.updateById(laboratory);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo()) :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(Laboratory laboratory) {
        Long departmentId = laboratory.getDepartmentId();
        Long teacherId = laboratory.getTeacherId();
        // TODO 判断是否存在对应的学院和管理老师

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


}
