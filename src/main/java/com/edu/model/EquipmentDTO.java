package com.edu.model;

import com.edu.entity.Equipment;
import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.time.LocalDate;

/**
 * @ClassName EquipmentDTO
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/15 9:00
 * @Version
 */

@Data
public class EquipmentDTO {
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
    // 所属部门名称
    private String departmentName;
}
