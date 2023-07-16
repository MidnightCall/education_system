package com.edu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName GrowthRecord
 * @Description
 * @Author Lucas Wang
 * @Date 2023/7/15 15:06
 * @Version
 */
@Data
@TableName("growth_record")
public class GrowthRecord {
    // 主键ID
    @TableId("id")
    private Long id;

    // 对应学生ID
    private Long stuId;

    // 学年
    private Integer year;

    // 学习情况，200字以内
    private String learning;

    // 科研情况，200字以内
    private String research;

    // 社会工作情况，200字以内
    private String social;
}
