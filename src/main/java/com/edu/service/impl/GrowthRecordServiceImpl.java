package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.GrowthRecord;
import com.edu.entity.Student;
import com.edu.mapper.GrowthRecordMapper;
import com.edu.service.IGrowthRecordService;
import com.edu.service.IStudentService;
import com.edu.utils.ids.IIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @ClassName GrowthRecordServiceImpl
 * @Description TODO
 * @Author LucasWang
 * @Date 2023/7/15 16:11:22
 * @Version 1.0
 */
@Service
@Slf4j
public class GrowthRecordServiceImpl extends ServiceImpl<GrowthRecordMapper, GrowthRecord> implements IGrowthRecordService {
    @Resource
    private Map<Constants.Ids, IIdGenerator> map;
    @Resource
    private IStudentService studentService;

    @Override
    public Result getById(Long id) {
        GrowthRecord growthRecord = super.getById(id);
        if (growthRecord == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
        }

        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), growthRecord);
    }

    @Override
    public Result getAll() {
        List<GrowthRecord> growthRecordList = super.list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), growthRecordList);
    }

    @Override
    public Result getByStudentId(Long studentId) {
        List<GrowthRecord> growthRecordList = query().eq("stu_id", studentId).list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), growthRecordList);
    }

    @Override
    public Result update(GrowthRecord growthRecord) {
        if(!isValid(growthRecord)){
            return Result.buildErrorResult("学生id或学年不正确，或者学习情况为空！");
        }
        boolean flag = super.updateById(growthRecord);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo()) :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(GrowthRecord growthRecord) {
        if(!isValid(growthRecord)){
            return Result.buildErrorResult("学生id或学年不正确，或者学习情况为空！");
        }

        GrowthRecord record = query().eq("stu_id", growthRecord.getStuId())
                .eq("year", growthRecord.getYear()).one();
        if(record != null){
            return Result.buildErrorResult("已有此记录");
        }

        growthRecord.setId(map.get(Constants.Ids.SnowFlake).nextId());
        boolean flag = super.save(growthRecord);
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

    private boolean isValid(GrowthRecord growthRecord) {
        Integer year = growthRecord.getYear();
        if(year == null || year < 1980 || year > 2040){
            return false;
        }

        String learning = growthRecord.getLearning();
        if(learning == null || learning.isEmpty()){
            return false;
        }

        Long stuId = growthRecord.getStuId();
        Student student = studentService.query().eq("id", stuId).one();
        if(student == null){
            return false;
        }

        return true;
    }
}

