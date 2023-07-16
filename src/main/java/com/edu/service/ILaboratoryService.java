package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.model.LaboratoryDTO;

import java.util.List;

/**
 * @ClassName ILaboratoryController
 * @Description 实验室接口
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:35
 * @Version
 */

public interface ILaboratoryService extends IService<Laboratory> {

    /**
     * 查单个
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
     * 更新
     * @param laboratory
     * @return
     */
    Result update(Laboratory laboratory);

    /**
     * 插入
     * @param laboratory 插入数据
     * @return
     */
    Result insert(Laboratory laboratory);

    /**
     * 删除
     * @param id 删除Id
     * @return
     */
    Result deleteById(List<Long> id);

    /**
     * 模糊查询接口
     * @param laboratory 实验室封装类
     * @return           查询结果
     */
    Result fuzzyQuery(LaboratoryDTO laboratory);
}
