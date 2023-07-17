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
 * @Description
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
     * 查询单个设备
     * @param id 设备id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return equipmentService.getById(id);
    }

    /**
     * 查询所有设备
     * @return 查询结果
     */
    @GetMapping
    public Result getAll(){
        return equipmentService.getAll();
    }

    /**
     * 更新设备信息
     * @param equipment 设备的新信息
     * @return 更新结果
     */
    @PostMapping
    public Result update(@RequestBody Equipment equipment){
        return equipmentService.update(equipment);
    }

    /**
     * 新增设备
     * @param equipment 新设备的信息
     * @return 新增结果
     */
    @PutMapping
    public Result insert(@RequestBody Equipment equipment) {
        return equipmentService.insert(equipment);
    }

    /**
     * 批量删除设备
     * @param ids 需要删除的设备id列表
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return equipmentService.deleteById(ids);
    }

    /**
     * 模糊查询设备
     * @param equipment 模糊查询的参数
     * @return 查询结果
     */
    @PostMapping("/like")
    public Result fuzzyQuery(@RequestBody EquipmentDTO equipment) {
        return equipmentService.fuzzyQuery(equipment);
    }
}
