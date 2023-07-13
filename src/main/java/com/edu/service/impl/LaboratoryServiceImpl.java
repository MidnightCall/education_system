package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.mapper.LaboratoryMapper;
import com.edu.service.ILaboratoryService;

import javax.annotation.Resource;

/**
 * @ClassName ILaboratoryController
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:35
 * @Version
 */

public class LaboratoryServiceImpl extends ServiceImpl<LaboratoryMapper, Laboratory> implements ILaboratoryService {
    @Override
    public Result getById(Long id) {
        LambdaQueryWrapper<Laboratory> lambdaQueryWrapper = new LambdaQueryWrapper<Laboratory>();
        lambdaQueryWrapper.eq(Laboratory::getLaboratoryId, id);
        LambdaQueryWrapper<Laboratory> laboratoryList = lambdaQueryWrapper.select();
        return Result.buildResult(Constants.OK, laboratoryList);
    }

    @Override
    public Result getAll() {
        Result laboratoryList = getAll();
        return Result.buildResult(Constants.OK, laboratoryList);
    }

    @Override
    public Result update(Laboratory laboratory) {
        return null;

    }

    @Override
    public Result insert(Laboratory laboratory) {
        return null;
    }

    @Override
    public Result deleteById(Long id) {
        return null;
    }
}
