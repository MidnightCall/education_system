package com.edu.model;

import com.edu.entity.Laboratory;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName LaboratoryDTO
 * @Description 实验室聚合类，用于前端展示
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/15 9:15
 * @Version
 */
@Data
public class LaboratoryDTO implements Serializable {
    // 主键Id
    private Long id;
    // 实验室名称
    private String name;
    // 地址
    private String address;
    // 学院Id
    private Long departmentId;
    // 实验室名称
    private String departmentName;
}
