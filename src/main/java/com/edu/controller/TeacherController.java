package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Teacher;
import com.edu.model.TeacherDTO;
import com.edu.service.ITeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TeacherController
 * @Description 教师Controller
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:22
 * @Version
 */
@RestController
@RequestMapping("/teacher")
@Api
public class TeacherController {
    @Resource
    private ITeacherService teacherService;

    /**
     * 查询单个教师
     * @param id 教师id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    @ApiOperation("通过ID查询教师信息")
    public Result getById(@ApiParam(name = "教师ID", value = "ID", required = true) @PathVariable Long id){
        return teacherService.getById(id);
    }

    /**
     * 查询所有教师
     * @return 所有教师的查询结果
     */
    @GetMapping
    @ApiOperation("获取所有教师数据")
    public Result getAll(){
        return teacherService.getAll();
    }

    /**
     * 更新教师
     * @param teacher 更新后的教师信息
     * @return 更新结果
     */
    @PostMapping
    @ApiOperation("更新教师信息")
    public Result update(@ApiParam(name = "教师信息", value = "更新数据", required = true) @RequestBody Teacher teacher){
        return teacherService.update(teacher);
    }

    /**
     * 新增教师
     * @param teacher 新的教师信息
     * @return 新增结果
     */
    @PutMapping
    @ApiOperation("新增学生信息")
    public Result insert(@ApiParam(name = "教师信息", value = "更新数据", required = true) @RequestBody Teacher teacher) {
        return teacherService.insert(teacher);
    }

    /**
     * 批量删除教师
     * @param ids 需要删除的教师id列表
     * @return 删除结果
     */
    @PostMapping("/delete")
    @ApiOperation("删除教师")
    public Result deleteById(@ApiParam(name = "教师ID", value = "ID", required = true) @RequestBody List<Long> ids) {
        return teacherService.deleteById(ids);
    }

    /**
     * 模糊查询
     * @param teacher   封装的DTO类
     * @return          查询结果
     */
    @PostMapping("/like")
    @ApiOperation("教师模糊查询")
    public Result fuzzyQuery(@ApiParam(name = "教师信息", value = "教师查询数据", required = true) @RequestBody TeacherDTO teacher){
        return teacherService.fuzzyQuery(teacher);
    }
}


