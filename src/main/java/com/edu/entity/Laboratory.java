package com.edu.entity;

import lombok.Data;

/**
 * @ClassName Laboratory
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 14:55
 * @Version
 */

@Data
public class Laboratory {
    // 实验室ID
    private String laboratoryId;
    // 实验室名称
    private String laboratoryName;
    // 实验室类型
    private String laboratoryType;
}
