package com.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.commons.Result;
import com.edu.entity.Growth;
import com.edu.mapper.GrowthMapper;
import com.edu.service.IGrowthService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 朱嘉诚
 * @Date: 2023/7/15 18:50
 * @Description:
 */
@Service
public class GrowthServiceImpl extends ServiceImpl<GrowthMapper, Growth> implements IGrowthService {
    @Override
    public Result listByStuId(Long stuId) {
        LambdaQueryWrapper<Growth> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Growth::getStuId, stuId);
        return Result.buildSuccessResult(list(queryWrapper));
    }
}
