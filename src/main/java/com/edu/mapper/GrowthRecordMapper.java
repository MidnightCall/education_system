package com.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.entity.GrowthRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName GrowthRecordMapper
 * @Description 成长信息仓储服务
 * @Author LucasWang
 * @Date 2023/7/15 16:12:25
 * @Version 1.0
 */
@Mapper
public interface GrowthRecordMapper extends BaseMapper<GrowthRecord> {
}
