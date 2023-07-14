package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Department;
import com.edu.service.IDepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DepartmentController
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:22
 * @Version
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private IDepartmentService departmentService;

    @GetMapping("/{id}")
    public Result queryById(@PathVariable("id") Long id){
        return departmentService.queryById(id);
    }

    @GetMapping
    public Result queryAll(){
        return departmentService.queryAll();
    }

    @PostMapping
    public Result update(Department department){
        return departmentService.update(department);
    }

    @PutMapping
    public Result insert(Department department){
        return departmentService.insert(department);
    }

    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return departmentService.deleteById(ids);
    }
}
