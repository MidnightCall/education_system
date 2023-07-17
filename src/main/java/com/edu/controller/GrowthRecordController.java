package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.GrowthRecord;
import com.edu.service.IGrowthRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName GrowthRecordController
 * @Description 成长信息Controller
 * @Author LucasWang
 * @Date 2023/7/15 16:00:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/growth/record")
public class GrowthRecordController {
    @Resource
    private IGrowthRecordService growthRecordService;

    /**
     * 查询单个成长记录
     * @param id 成长记录id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return growthRecordService.getById(id);
    }

    /**
     * 查询所有成长记录
     * @return 查询结果
     */
    @GetMapping
    public Result getAll(){
        return growthRecordService.getAll();
    }

    /**
     * 查询指定学生的所有成长记录
     * @param studentId 指定学生的id
     * @return 查询结果
     */
    @GetMapping("/all/of/{id}")
    public Result getByStudentId(@PathVariable("id") Long studentId){
        return growthRecordService.getByStudentId(studentId);
    }

    /**
     * 更新成长记录
     * @param growthRecord 成长记录新的信息
     * @return 更新结果
     */
    @PostMapping
    public Result update(@RequestBody GrowthRecord growthRecord){
        return growthRecordService.update(growthRecord);
    }

    /**
     * 新增成长记录
     * @param growthRecord 新的成长记录
     * @return 新增结果
     */
    @PutMapping
    public Result insert(@RequestBody GrowthRecord growthRecord) {
        return growthRecordService.insert(growthRecord);
    }

    /**
     * 批量删除成长记录
     * @param ids 需要删除的成长记录id列表
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return growthRecordService.deleteById(ids);
    }
}
