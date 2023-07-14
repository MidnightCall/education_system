package com.edu.service;

import com.edu.commons.Result;
import com.edu.entity.Laboratory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName LaboratoryTest
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 14:35
 * @Version
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LaboratoryTest {
    @Resource
    private ILaboratoryService laboratoryService;

    @Test
    public void testInsert() {
        Laboratory laboratory1 = new Laboratory();
        laboratory1.setName("理塘");
        laboratory1.setAddress("世界最高城");
        laboratory1.setTeacherId(100001L);
        laboratory1.setDepartmentId(101L);
        Result result1 = laboratoryService.insert(laboratory1);
        log.info("code:{} info:{}", result1.getCode(), result1.getInfo());

        Laboratory laboratory2 = new Laboratory();
        laboratory2.setName("四川大学男厕所");
        laboratory2.setAddress("null");
        laboratory2.setTeacherId(100002L);
        laboratory2.setDepartmentId(102L);
        Result result2 = laboratoryService.insert(laboratory2);

        log.info("code:{} info:{}", result2.getCode(), result2.getInfo());
    }
}
