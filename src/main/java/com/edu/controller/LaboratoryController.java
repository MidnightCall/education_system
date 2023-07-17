package com.edu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.model.LaboratoryDTO;
import com.edu.service.ILaboratoryService;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName LaboratoryController
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 14:59
 * @Version
 */

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {

    @Resource
    private ILaboratoryService laboratoryService;

    /**
     * 查询单个实验室
     * @param id 实验室id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return laboratoryService.getById(id);
    }

    /**
     * 查询所有实验室
     * @return 查询结果
     */
    @GetMapping
    public Result getAll(){
        return laboratoryService.getAll();
    }

    /**
     * 更新实验室信息
     * @param laboratory 实验室的新信息
     * @return 更新结果
     */
    @PostMapping
    public Result update(@RequestBody Laboratory laboratory){
        return laboratoryService.update(laboratory);
    }

    /**
     * 新增实验室
     * @param laboratory 新的实验室
     * @return 新增结果
     */
    @PutMapping
    public Result insert(@RequestBody Laboratory laboratory) {
        return laboratoryService.insert(laboratory);
    }

    /**
     * 批量删除实验室
     * @param ids 批量删除的实验室id列表
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return laboratoryService.deleteById(ids);
    }

    /**
     * 模糊查询
     * @param laboratory 模糊查询的参数
     * @return 查询结果
     */
    @PostMapping("/like")
    public Result fuzzyQuery(@RequestBody LaboratoryDTO laboratory) {
        return laboratoryService.fuzzyQuery(laboratory);
    }

}
