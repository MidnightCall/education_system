package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Student;
import com.edu.entity.Teacher;
import com.edu.model.EquipmentDTO;
import com.edu.model.StudentDTO;
import com.edu.service.IStudentService;
import com.edu.service.ITeacherService;
import com.kojikoji.middleware.ratelimiter.annotation.DoRateLimiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName StudentController
 * @Description 学生Controller
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 14:59
 * @Version
 */
@RestController
@RequestMapping("/student")
@Api
public class StudentController {

    @Resource
    private IStudentService studentService;

    /**
     * 查询单个学生
     * @param id 学生id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    @ApiOperation("通过ID查询学生信息")
    @DoRateLimiter(permitsPerSecond = 100, returnJson = "超出流量限制")
    public Result getById(@ApiParam(name = "学生ID", value = "ID", required = true) @PathVariable Long id){
        return studentService.getById(id);
    }

    /**
     * 查询所有学生
     * @return 所有学生的列表
     */
    @GetMapping
    @ApiOperation("获取所有学生信息")
    @DoRateLimiter(permitsPerSecond = 100, returnJson = "超出流量限制")
    public Result getAll(){
        return studentService.getAll();
    }

    /**
     * 更新学生
     * @param student 学生新的信息
     * @return 更新结果
     */
    @PostMapping
    @ApiOperation("更新学生信息")
    public Result update(@ApiParam(name = "学生信息", value = "更新数据", required = true) @RequestBody Student student){
        return studentService.update(student);
    }

    /**
     * 新增学生
     * @param student 新的学生的信息
     * @return 新增结果
     */
    @PutMapping
    @ApiOperation("新增学生信息")
    public Result insert(@ApiParam(name = "学生信息", value = "更新数据", required = true) @RequestBody Student student) {
        return studentService.insert(student);
    }

    /**
     * 批量删除学生
     * @param ids 需要删除学生的id列表
     * @return 删除结果
     */
    @PostMapping("/delete")
    @ApiOperation("删除学生")
    public Result deleteById(@ApiParam(name = "学生ID", value = "ID", required = true) @RequestBody List<Long> ids) {
        return studentService.deleteById(ids);
    }

    /**
     * 模糊查询
     * @param studentDTO
     * @return
     */
    @PostMapping("/like")
    @ApiOperation("学生模糊查询")
    public Result fuzzyQuery(@ApiParam(name = "学生信息", value = "学生查询数据", required = true) @RequestBody StudentDTO studentDTO) {
        return studentService.fuzzyQuery(studentDTO);
    }

}
