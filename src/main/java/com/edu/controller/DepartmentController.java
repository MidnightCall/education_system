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
 * @Author Lucas Wang
 * @Date 2023/7/13 16:22
 * @Version
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private IDepartmentService departmentService;

    /**
     * 查询单个部门
     * @param id 部门的id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    public Result queryById(@PathVariable("id") Long id){
        return departmentService.queryById(id);
    }

    /**
     * 查询所有部门
     * @return 查询所有部门的结果
     */
    @GetMapping
    public Result queryAll(){
        return departmentService.queryAll();
    }

    /**
     * 更新单个部门
     * @param department 更新参数，包含部门新的名字、地址
     * @return 更新结果
     */
    @PostMapping
    public Result update(Department department){
        return departmentService.update(department);
    }

    /**
     * 插入新的部门
     * @param department 插入参数，包含新部门的名字和地址
     * @return 插入结果
     */
    @PutMapping
    public Result insert(Department department){
        return departmentService.insert(department);
    }

    /**
     * 根据id列表批量删除部门
     * @param ids 需要删除的部门的id列表
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return departmentService.deleteById(ids);
    }
}
