package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.GrowthRecord;

import java.util.List;

/**
 * @ClassName IGrowthRecordService
 * @Description TODO
 * @Author LucasWang
 * @Date 2023/7/15 16:10:15
 * @Version 1.0
 */
public interface IGrowthRecordService extends IService<GrowthRecord> {

    Result getById(Long id);

    Result getAll();

    Result getByStudentId(Long studentId);

    Result update(GrowthRecord growthRecord);

    Result insert(GrowthRecord growthRecord);

    Result deleteById(List<Long> ids);
}
