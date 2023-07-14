package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Teacher;
import com.edu.service.ITeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TeacherController
 * @Description 
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 16:22
 * @Version
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private ITeacherService teacherService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return teacherService.getById(id);
    }

    @GetMapping
    public Result getAll(){
        return teacherService.getAll();
    }

    @PostMapping
    public Result update(@RequestBody Teacher teacher){
        return teacherService.update(teacher);
    }

    @PutMapping
    public Result insert(@RequestBody Teacher teacher) {
        return teacherService.insert(teacher);
    }

    @DeleteMapping
    public Result deleteById(List<Long> ids) {
        return teacherService.deleteById(ids);
    }
}


