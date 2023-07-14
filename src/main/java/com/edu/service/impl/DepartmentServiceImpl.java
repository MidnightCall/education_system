package com.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.entity.Department;
import com.edu.entity.Equipment;
import com.edu.mapper.DepartmentMapper;
import com.edu.mapper.EquipmentMapper;
import com.edu.service.IDepartmentService;
import com.edu.service.IEquipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName DepartmentServiceImpl
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 20:07
 * @Version
 */
@Slf4j
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
}
