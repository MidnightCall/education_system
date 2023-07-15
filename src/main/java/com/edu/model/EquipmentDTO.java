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
public class EquipmentDTO extends Equipment{
    // 所属部门名称
    private String departmentName;
}
