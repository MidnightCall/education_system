package com.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.commons.Result;
import com.edu.entity.Growth;

import java.util.List;

/**
 * @Auther: 朱嘉诚
 * @Date: 2023/7/15 18:49
 * @Description:
 */
public interface IGrowthService extends IService<Growth> {
    Result listByStuId(Long stuId);
}
