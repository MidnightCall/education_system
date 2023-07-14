package com.edu.service;

import cn.hutool.core.lang.UUID;
import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Teacher;
import com.edu.utils.ids.IIdGenerator;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

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

    @Resource
    private Map<Constants.Ids, IIdGenerator> map;

    @Test
    public void testInsert() {
        Teacher teacher1 = new Teacher();
        teacher1.setId(map.get(Constants.Ids.ShortCode).nextId());
        teacher1.setGender(0);
        teacher1.setDepartment("抽烟学院");
        teacher1.setJob("rapper");
        teacher1.setName("芙蓉王源");
        teacher1.setPhone("114514");
        teacher1.setSalary(114514L);
        Result result1 = teacherService.insert(teacher1);
        logger.info("code : {} info : {}", result1.getCode(), result1.getInfo());

        Teacher teacher2 = new Teacher();
        teacher2.setId(map.get(Constants.Ids.ShortCode).nextId());
        teacher2.setGender(0);
        teacher2.setDepartment("抽烟学院");
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
        teacher2.setDepartment("打胶学院");
        teacher2.setJob("rapper");
        teacher2.setName("尼古丁真");
        teacher2.setPhone("114514");
        teacher2.setSalary(114514L);
        Result result2 = teacherService.update(teacher2);
        logger.info("code : {} info : {}", result2.getCode(), result2.getInfo());
    }

    public void testDelete() {

    }
}
