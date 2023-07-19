package com.edu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.model.LaboratoryDTO;
import com.edu.service.ILaboratoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName LaboratoryController
 * @Description 实验室Controller
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 14:59
 * @Version
 */

@RestController
@RequestMapping("/laboratory")
@Api
public class LaboratoryController {

    @Resource
    private ILaboratoryService laboratoryService;

    /**
     * 数据回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("通过ID查询实验室信息")
    public Result getById(@ApiParam(name = "实验室ID", value = "ID", required = true) @PathVariable Long id){
        return laboratoryService.getById(id);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    @ApiOperation("查询所有实验室信息")
    public Result getAll(){
        return laboratoryService.getAll();
    }

    /**
     * 更新
     * @param laboratory
     * @return
     */
    @PostMapping
    @ApiOperation("更新实验室信息")
    public Result update(@ApiParam(name = "实验室", value = "更新数据", required = true) @RequestBody Laboratory laboratory){
        return laboratoryService.update(laboratory);
    }

    /**
     * 新增
     * @param laboratory
     * @return
     */
    @PutMapping
    @ApiOperation("新增实验室数据")
    public Result insert(@ApiParam(name = "实验室", value = "更新数据", required = true) @RequestBody Laboratory laboratory) {
        return laboratoryService.insert(laboratory);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation("删除实验室")
    public Result deleteById(@ApiParam(name = "实验室ID", value = "ID", required = true) @RequestBody List<Long> ids) {
        return laboratoryService.deleteById(ids);
    }

    /**
     * 模糊查询
     * @param laboratory
     * @return
     */
    @PostMapping("/like")
    @ApiOperation("实验室模糊查询")
    public Result fuzzyQuery(@ApiParam(name = "实验室", value = "查询数据", required = true) @RequestBody LaboratoryDTO laboratory) {
        return laboratoryService.fuzzyQuery(laboratory);
    }

}
