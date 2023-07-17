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
 * @Description 实验室Controller
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
     * 数据回显
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return laboratoryService.getById(id);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping
    public Result getAll(){
        return laboratoryService.getAll();
    }

    /**
     * 更新
     * @param laboratory
     * @return
     */
    @PostMapping
    public Result update(@RequestBody Laboratory laboratory){
        return laboratoryService.update(laboratory);
    }

    /**
     * 新增
     * @param laboratory
     * @return
     */
    @PutMapping
    public Result insert(@RequestBody Laboratory laboratory) {
        return laboratoryService.insert(laboratory);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return laboratoryService.deleteById(ids);
    }

    /**
     * 模糊查询
     * @param laboratory
     * @return
     */
    @PostMapping("/like")
    public Result fuzzyQuery(@RequestBody LaboratoryDTO laboratory) {
        return laboratoryService.fuzzyQuery(laboratory);
    }

}
