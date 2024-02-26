package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.GrowthRecord;
import com.edu.entity.Student;
import com.edu.mapper.GrowthRecordMapper;
import com.edu.model.LaboratoryDTO;
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
 * @Description 成长记录模块的服务
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
        // 根据id查询对应成长记录
        GrowthRecord growthRecord = super.getById(id);
        // 若不存在，则返回失败结果
        if (growthRecord == null) {
            return Result.buildErrorResult(Constants.OperationMessage.SELECT_FAIL.getInfo());
        }
        // 返回查询结果
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), growthRecord);
    }

    @Override
    public Result getAll() {
        // 查询所有的成长记录，将列表返回
        List<GrowthRecord> growthRecordList = super.list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), growthRecordList);
    }

    @Override
    public Result getByStudentId(Long studentId) {
        // 根据学生id查询对应的成长记录，将列表返回
        List<GrowthRecord> growthRecordList = query().eq("stu_id", studentId).list();
        return Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.SELECT_SUCCESS.getInfo(), growthRecordList);
    }

    @Override
    public Result update(GrowthRecord growthRecord) {
        // 如果成长记录的信息不合规，则返回失败结果
        if(!isValid(growthRecord)){
            return Result.buildErrorResult("学生id或学年不正确，或者学习情况为空！");
        }
        // 更新成长记录，返回结果
        boolean flag = super.updateById(growthRecord);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.UPDATE_SUCCESS.getInfo()) :
                Result.buildErrorResult(Constants.OperationMessage.UPDATE_FAIL.getInfo());
    }

    @Override
    public Result insert(GrowthRecord growthRecord) {
        // 如果成长记录的信息不合规，则返回失败结果
        if(!isValid(growthRecord)){
            return Result.buildErrorResult("学生id或学年不正确，或者学习情况为空！");
        }
        // 如果记录重复，则返回失败结果
        GrowthRecord record = query().eq("stu_id", growthRecord.getStuId())
                .eq("year", growthRecord.getYear()).one();
        if(record != null){
            return Result.buildErrorResult("已有此记录");
        }
        // 采用雪花算法分配id
        growthRecord.setId(map.get(Constants.Ids.SnowFlake).nextId());
        // 新增成长记录，返回结果
        boolean flag = super.save(growthRecord);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.INSERT_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.INSERT_FAIL.getInfo());
    }

    @Override
    public Result deleteById(List<Long> ids) {
        // 根据id列表删除成长记录，返回结果
        boolean flag = super.removeByIds(ids);
        return flag ?
                Result.buildResult(Constants.ResponseCode.OK, Constants.OperationMessage.DELETE_SUCCESS.getInfo(), "") :
                Result.buildErrorResult(Constants.OperationMessage.DELETE_FAIL.getInfo());
    }

    @Override
    public Result fuzzyQuery(LaboratoryDTO laboratory) {
        return Result.buildErrorResult("暂未开发此功能");
    }

    /**
     * 判断成长记录中的年份、学生id和学习情况是否合法
     * @param growthRecord 指定的成长记录
     * @return 是否合法
     */
    private boolean isValid(GrowthRecord growthRecord) {
        // 如果年份为空，或者年份不正常则返回false
        Integer year = growthRecord.getYear();
        if(year == null || year < 1980 || year > 2040){
            return false;
        }
        // 如果学习情况为空，则返回false
        String learning = growthRecord.getLearning();
        if(learning == null || learning.isEmpty()){
            return false;
        }
        // 如果对应学生不存在，则返回false
        Long stuId = growthRecord.getStuId();
        Student student = studentService.query().eq("id", stuId).one();
        if(student == null){
            return false;
        }

        return true;
    }
}

