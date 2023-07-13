package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import com.edu.service.ILaboratoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id) {
        return laboratoryService.deleteById(id);
    }
}
