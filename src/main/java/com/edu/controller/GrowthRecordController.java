package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.GrowthRecord;
import com.edu.model.LaboratoryDTO;
import com.edu.service.IGrowthRecordService;
import com.kojikoji.middleware.ratelimiter.annotation.DoRateLimiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
@Api
public class GrowthRecordController {
    @Resource
    private IGrowthRecordService growthRecordService;

    /**
     * 查询单个成长记录
     * @param id 成长记录id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    @ApiOperation("由ID查询成长信息")
    @DoRateLimiter(permitsPerSecond = 100, returnJson = "超出流量限制")
    public Result getById(@ApiParam(name = "成长信息ID", value = "ID", required = true) @PathVariable Long id){
        return growthRecordService.getById(id);
    }

    /**
     * 查询所有成长记录
     * @return 查询结果
     */
    @GetMapping
    @ApiOperation("查询所有成长信息")
    @DoRateLimiter(permitsPerSecond = 100, returnJson = "超出流量限制")
    public Result getAll(){
        return growthRecordService.getAll();
    }

    /**
     * 查询指定学生的所有成长记录
     * @param studentId 指定学生的id
     * @return 查询结果
     */
    @GetMapping("/all/of/{id}")
    @ApiOperation("由学生信息查询成长信息")
    public Result getByStudentId(@ApiParam(name = "学生ID", value = "ID", required = true) @PathVariable("id") Long studentId){
        return growthRecordService.getByStudentId(studentId);
    }

    /**
     * 更新成长记录
     * @param growthRecord 成长记录新的信息
     * @return 更新结果
     */
    @PostMapping
    @ApiOperation("更新成长信息")
    public Result update(@ApiParam(name = "成长信息", value = "更新数据", required = true) @RequestBody GrowthRecord growthRecord){
        return growthRecordService.update(growthRecord);
    }

    /**
     * 新增成长记录
     * @param growthRecord 新的成长记录
     * @return 新增结果
     */
    @PutMapping
    @ApiOperation("新增成长信息")
    public Result insert(@ApiParam(name = "成长信息", value = "更新数据", required = true) @RequestBody GrowthRecord growthRecord) {
        return growthRecordService.insert(growthRecord);
    }

    /**
     * 批量删除成长记录
     * @param ids 需要删除的成长记录id列表
     * @return 删除结果
     */
    @PostMapping("/delete")
    @ApiOperation("批量删除成长信息")
    public Result deleteById(@ApiParam(name = "成长信息ID", value = "ID", required = true) @RequestBody List<Long> ids) {
        return growthRecordService.deleteById(ids);
    }

    /**
     * 模糊查询
     * @param laboratory
     * @return
     */
    @PostMapping("/like")
    @ApiOperation("实验室模糊查询")
    public Result fuzzyQuery(@ApiParam(name = "实验室", value = "查询数据", required = true) @RequestBody LaboratoryDTO laboratory) {
        return growthRecordService.fuzzyQuery(laboratory);
    }
}
