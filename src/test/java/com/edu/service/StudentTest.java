package com.edu.service;

import com.edu.commons.Result;
import com.edu.entity.Student;
import com.edu.model.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * @ClassName StudentTest
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 16:00
 * @Version
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
    @Resource
    private IStudentService studentService;

    @Test
    public void testInsert() {
        Student student1 = new Student();
        student1.setGender(0);
        student1.setDepartmentId(236252161L);
        student1.setClazz("2020104");
        student1.setGrade("2020");
        student1.setName("丁真的小马");
        student1.setPhone("114514");
        Result result = studentService.insert(student1);

        Student student2 = new Student();
        student2.setGender(0);
        student2.setDepartmentId(236252165L);
        student2.setClazz("2020104");
        student2.setGrade("2020");
        student2.setName("陈睿的马");
        student2.setPhone("114514");
        Result result2 = studentService.insert(student2);

        log.info("code:{}, info:{}", result.getCode(), result.getInfo());
    }

    @Test
    public void testGet() {
//        Result all = studentService.getAll();
//        log.info("{}", all.getData());
//        log.info("code:{} info:{}", all.getCode(), all.getInfo());

        Result byId = studentService.getById(2019102839L);
        log.info("{}", byId.getData());
        log.info("code:{} info:{}", byId.getCode(), byId.getInfo());
    }

    @Test
    public void testFuzzyQuery() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setDepartmentName("办公");
        Result result = studentService.fuzzyQuery(studentDTO);
        log.info("{}", result.getData());
        log.info("code:{} info:{}", result.getCode(), result.getInfo());
    }
}
