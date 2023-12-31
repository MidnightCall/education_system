package com.edu.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @ClassName Equipment
 * @Description 设备数据库映射
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 14:55
 * @Version
 */
@Data
public class Equipment {
    // 主键ID
    private Long id;

    // 设备名称
    private String name;

    // 设备描述
    private String description;

    // 设备价格
    private Long price;

    // 设备类型
    private String type;

    // 购买时间
    private LocalDate purchaseTime;

    // 所属的部门ID
    private Long departmentId;
}
