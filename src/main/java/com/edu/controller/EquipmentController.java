package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.service.IEquipmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName equipmentController
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

    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return equipmentService.getById(id);
    }

    @GetMapping
    public Result getAll(){
        return equipmentService.getAll();
    }

    @PostMapping
    public Result update(@RequestBody Equipment equipment){
        return equipmentService.update(equipment);
    }

    @PutMapping
    public Result insert(@RequestBody Equipment equipment) {
        return equipmentService.insert(equipment);
    }

    @PostMapping("/{id}")
    public Result deleteById(@RequestBody List<Long> ids) {
        return equipmentService.deleteById(ids);
    }

}
