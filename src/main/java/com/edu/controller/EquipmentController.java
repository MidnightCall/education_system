package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.model.EquipmentDTO;
import com.edu.model.LaboratoryDTO;
import com.edu.service.IEquipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
@Api
public class EquipmentController {
    @Resource
    private IEquipmentService equipmentService;

    /**
     * 查询单个设备
     * @param id 设备id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "更新设备")
    public Result getById(@ApiParam(name = "设备ID", value = "id", required = true) @PathVariable Long id){
        return equipmentService.getById(id);
    }

    /**
     * 查询所有设备
     * @return 查询结果
     */
    @GetMapping
    @ApiOperation(value = "获取所有设备")
    public Result getAll(){
        return equipmentService.getAll();
    }

    /**
     * 更新设备信息
     * @param equipment 设备的新信息
     * @return 更新结果
     */
    @PostMapping
    @ApiOperation(value = "更新设备")
    public Result update(@ApiParam(name = "设备", value = "更新数据", required = true) @RequestBody Equipment equipment){
        return equipmentService.update(equipment);
    }

    /**
     * 新增设备
     * @param equipment 新设备的信息
     * @return 新增结果
     */
    @PutMapping
    @ApiOperation(value = "新增设备")
    public Result insert(@ApiParam(name = "设备", value = "更新数据", required = true) @RequestBody Equipment equipment) {
        return equipmentService.insert(equipment);
    }

    /**
     * 批量删除设备
     * @param ids 需要删除的设备id列表
     * @return 删除结果
     */
    @PostMapping("/delete")
    @ApiOperation("删除设备")
    public Result deleteById(@ApiParam(name = "设备ID", value = "ID", required = true) @RequestBody List<Long> ids) {
        return equipmentService.deleteById(ids);
    }

    /**
     * 模糊查询设备
     * @param equipment 模糊查询的参数
     * @return 查询结果
     */
    @PostMapping("/like")
    @ApiOperation("设备模糊查询")
    public Result fuzzyQuery(@ApiParam(name = "设备", value = "查询数据", required = true) @RequestBody EquipmentDTO equipment) {
        return equipmentService.fuzzyQuery(equipment);
    }
}
