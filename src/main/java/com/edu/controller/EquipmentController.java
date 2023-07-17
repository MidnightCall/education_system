package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.model.EquipmentDTO;
import com.edu.model.LaboratoryDTO;
import com.edu.service.IEquipmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName EquipmentController
 * @Description 设备Controller
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 14:59
 * @Version
 */
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    
    @Resource
    private IEquipmentService equipmentService;

    /**
     * 单条查询接口，用于回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return equipmentService.getById(id);
    }

    /**
     * 查询所有接口
     * @return
     */
    @GetMapping
    public Result getAll(){
        return equipmentService.getAll();
    }

    /**
     * 更新接口
     * @param equipment
     * @return
     */
    @PostMapping
    public Result update(@RequestBody Equipment equipment){
        return equipmentService.update(equipment);
    }

    /**
     * 插入数据
     * @param equipment
     * @return
     */
    @PutMapping
    public Result insert(@RequestBody Equipment equipment) {
        return equipmentService.insert(equipment);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return equipmentService.deleteById(ids);
    }

    /**
     * 模糊查询
     * @param equipment
     * @return
     */
    @PostMapping("/like")
    public Result fuzzyQuery(@RequestBody EquipmentDTO equipment) {
        return equipmentService.fuzzyQuery(equipment);
    }
}
