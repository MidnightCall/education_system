package com.edu.model;

import lombok.Data;

/**
 * @ClassName LaboratoryDTO
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/15 9:15
 * @Version
 */
@Data
public class LaboratoryDTO {

    // 实验室ID
    private Long id;

    // 实验室名称
    private String name;

    // 实验室地址
    private String address;

    // 实验室名称
    private String departmentName;
}
