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

    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return growthRecordService.getById(id);
    }

    @GetMapping
    public Result getAll(){
        return growthRecordService.getAll();
    }

    @GetMapping("/all/of/{id}")
    public Result getByStudentId(@PathVariable("id") Long studentId){
        return growthRecordService.getByStudentId(studentId);
    }

    @PostMapping
    public Result update(@RequestBody GrowthRecord growthRecord){
        return growthRecordService.update(growthRecord);
    }

    @PutMapping
    public Result insert(@RequestBody GrowthRecord growthRecord) {
        return growthRecordService.insert(growthRecord);
    }

    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return growthRecordService.deleteById(ids);
    }
}
