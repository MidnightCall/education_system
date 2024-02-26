package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.GrowthRecord;
import com.edu.model.LaboratoryDTO;

import java.util.List;

/**
 * @ClassName IGrowthRecordService
 * @Description 成长信息业务接口定义
 * @Author LucasWang
 * @Date 2023/7/15 16:10:15
 * @Version 1.0
 */
public interface IGrowthRecordService extends IService<GrowthRecord> {

    /**
     * 回显
     * @param id
     * @return
     */
    Result getById(Long id);

    /**
     * 查全部
     * @return
     */
    Result getAll();

    /**
     * 由学生Id查询
     * @param studentId
     * @return
     */
    Result getByStudentId(Long studentId);

    /**
     * 更新
     * @param growthRecord
     * @return
     */
    Result update(GrowthRecord growthRecord);

    /**
     * 插入
     * @param growthRecord
     * @return
     */
    Result insert(GrowthRecord growthRecord);

    /**
     * 删除
     * @param ids
     * @return
     */
    Result deleteById(List<Long> ids);

    Result fuzzyQuery(LaboratoryDTO laboratory);
}
