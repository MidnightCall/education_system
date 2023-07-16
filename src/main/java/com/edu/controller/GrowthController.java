package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Growth;
import com.edu.service.IGrowthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 朱嘉诚
 * @Date: 2023/7/15 18:51
 * @Description:
 */
@RestController
@RequestMapping("/growth")
public class GrowthController {
    @Resource
    private IGrowthService growthService;

    @GetMapping("/{id}")
    public Result getByStuId(@PathVariable Long id){
        return Result.buildSuccessResult(growthService.listByStuId(id));
    }

    @PutMapping
    public Result insert(@RequestBody Growth growth){
        return Result.buildSuccessResult(growthService.save(growth));
    }

    @PostMapping
    public Result update(@RequestBody Growth growth){
        return Result.buildSuccessResult(growthService.saveOrUpdate(growth));
    }

    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return Result.buildSuccessResult(growthService.removeByIds(ids));
    }

}
