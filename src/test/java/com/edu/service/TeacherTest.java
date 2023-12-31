package com.edu.service;


import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Teacher;
import com.edu.model.TeacherDTO;
import com.edu.utils.ids.IIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * @ClassName TeacherTest
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 9:32
 * @Version
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTest {

    Logger logger = LoggerFactory.getLogger(TeacherTest.class);

    @Resource
    private ITeacherService teacherService;


    @Test
    public void testInsert() {
        Teacher teacher1 = new Teacher();
        teacher1.setGender(0);
        teacher1.setDepartmentId(236252161L);
        teacher1.setJob("negro");
        teacher1.setName("芙蓉王源");
        teacher1.setPhone("114514");
        teacher1.setSalary(114514L);
        Result result1 = teacherService.insert(teacher1);
        logger.info("code : {} info : {}", result1.getCode(), result1.getInfo());

        Teacher teacher2 = new Teacher();
        teacher2.setGender(0);
        teacher2.setDepartmentId(236252161L);
        teacher2.setJob("rapper");
        teacher2.setName("尼古丁真");
        teacher2.setPhone("114514");
        teacher2.setSalary(114514L);
        Result result2 = teacherService.insert(teacher2);
        logger.info("code : {} info : {}", result2.getCode(), result2.getInfo());
    }

    @Test
    public void testUpdate() {
        Teacher teacher2 = new Teacher();
        teacher2.setId(39286048L);
        teacher2.setGender(0);
        teacher2.setDepartmentId(101L);
        teacher2.setJob("rapper");
        teacher2.setName("尼古丁真");
        teacher2.setPhone("114514");
        teacher2.setSalary(114514L);
        Result result2 = teacherService.update(teacher2);
        logger.info("code : {} info : {}", result2.getCode(), result2.getInfo());
    }

    @Test
    public void testDelete() {
        List<Long> id = new ArrayList<>();
        id.add(39286121L);
        id.add(39286137L);
        Result result = teacherService.deleteById(id);
        logger.info("code : {} info : {}", result.getCode(), result.getInfo());
    }

    @Test
    public void testGet() {
        Result all = teacherService.getAll();
        logger.info("{}", all.getData());



//        Result teacher = teacherService.getById(39286121L);
//        logger.info("{}", teacher);
    }

    @Test
    public void testFuzzyQuery() {
        TeacherDTO teacherDTO = new TeacherDTO();
//        teacherDTO.setDepartmentName("办公");
//        teacherDTO.setName("尼古");
        teacherDTO.setSalary(16000L);
        Result result = teacherService.fuzzyQuery(teacherDTO);
        logger.info("{}", result.getData());
        logger.info("code:{} info:{}", result.getCode(), result.getInfo());
    }
}
