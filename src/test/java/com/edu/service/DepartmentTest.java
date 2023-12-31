package com.edu.service;

import com.edu.commons.Result;
import com.edu.entity.Department;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TeacherTest
 * @Description
 * @Author Lucas Wang
 * @Date 2023/7/14 9:32
 * @Version
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DepartmentTest {
    @Resource
    private IDepartmentService departmentService;

    @Test
    public void testInsert() {
        Department department1 = new Department();
        department1.setName("教务处");
        department1.setAddress("行政楼");
        Result result = departmentService.insert(department1);
        log.info("code : {} info : {}", result.getCode(), result.getInfo());

        Department department2 = new Department();
        department2.setName("学工部");
        department2.setAddress("行政楼");
        result = departmentService.insert(department2);
        log.info("code : {} info : {}", result.getCode(), result.getInfo());
    }

    @Test
    public void testUpdate() {
        Result result = departmentService.queryById(236252162L);
        Department department = (Department) result.getData();
        department.setAddress("四川大学");
        result = departmentService.update(department);
        log.info("code : {} info : {}", result.getCode(), result.getInfo());
    }

    @Test
    public void testGet() {
        Result all = departmentService.queryAll();
        for(Department department : (List<Department>) all.getData()){
            log.info("{}, ", department);
        }

        Result department = departmentService.queryById(236252162L);
        log.info("{}", department);
    }

    @Test
    public void testDelete() {
        List<Long> ids = new ArrayList<>();
        ids.add(236252162L);
        ids.add(236252163L);
        Result result = departmentService.deleteById(ids);
        log.info("code : {} info : {}", result.getCode(), result.getInfo());
    }
}
