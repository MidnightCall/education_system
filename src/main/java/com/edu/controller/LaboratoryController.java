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

    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return laboratoryService.getById(id);
    }

    @GetMapping
    public Result getAll(){
        return laboratoryService.getAll();
    }

    @PostMapping
    public Result update(@RequestBody Laboratory laboratory){
        return laboratoryService.update(laboratory);
    }

    @PutMapping
    public Result insert(@RequestBody Laboratory laboratory) {
        return laboratoryService.insert(laboratory);
    }

    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return laboratoryService.deleteById(ids);
    }

    @PostMapping("/like")
    public Result fuzzyQuery(@RequestBody LaboratoryDTO laboratory) {
        return laboratoryService.fuzzyQuery(laboratory);
    }

}
