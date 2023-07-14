package com.edu.controller;

import com.edu.commons.Result;
import com.edu.entity.Student;
import com.edu.entity.Teacher;
import com.edu.service.IStudentService;
import com.edu.service.ITeacherService;
import com.sun.xml.internal.ws.addressing.WsaServerTube;
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

    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @GetMapping
    public Result getAll(){
        return studentService.getAll();
    }

    @PostMapping
    public Result update(@RequestBody Student student){
        return studentService.update(student);
    }

    @PutMapping
    public Result insert(@RequestBody Student student) {
        return studentService.insert(student);
    }

    @PostMapping("/delete")
    public Result deleteById(@RequestBody List<Long> ids) {
        return studentService.deleteById(ids);
    }

}
