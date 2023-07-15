package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Student;
import com.edu.entity.Teacher;
import com.edu.service.IStudentService;
import com.edu.service.ITeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName StudentController
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 14:59
 * @Version
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

    /**
     * 查询单个学生
     * @param id 学生id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    /**
     * 查询所有学生
     * @return 所有学生的列表
     */
    @GetMapping
    public Result getAll(){
        return studentService.getAll();
    }

    /**
     * 更新学生
     * @param student 学生新的信息
     * @return 更新结果
     */
    @PostMapping
    public Result update(@RequestBody Student student){
        return studentService.update(student);
    }

    /**
     * 新增学生
     * @param student 新的学生的信息
     * @return 新增结果
     */
    @PutMapping
    public Result insert(@RequestBody Student student) {
        return studentService.insert(student);
    }

    /**
     * 批量删除学生
     * @param ids 需要删除学生的id列表
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return studentService.deleteById(ids);
    }

}
