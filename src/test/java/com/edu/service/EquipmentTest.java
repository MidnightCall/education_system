package com.edu.service;

import com.edu.commons.Constants;
import com.edu.commons.Result;
import com.edu.entity.Equipment;
import com.edu.utils.ids.IIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName EquipmentTest
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 13:50
 * @Version
 */


@SpringBootTest
@RunWith(SpringRunner.class)
public class EquipmentTest {

    @Resource
    private IEquipmentService equipmentService;

    @Resource
    private Map<Constants.Ids, IIdGenerator> map;

    private Logger logger = LoggerFactory.getLogger(EquipmentTest.class);

    @Test
    public void testInsert() {
        Equipment equipment1 = new Equipment();
        equipment1.setDescription("呜呼呜呼真的好满足");
        equipment1.setName("瑞克5");
        equipment1.setType("电子烟");
        equipment1.setPurchaseTime(LocalDateTime.now().toLocalDate());
        equipment1.setPrice(996L);
        equipment1.setDepartmentId(map.get(Constants.Ids.RandomNumeric).nextId());
        Result result1 = equipmentService.insert(equipment1);

        Equipment equipment2 = new Equipment();
        equipment2.setDescription("从理塘到了上海，哥们收获好多money");
        equipment2.setName("芙蓉王");
        equipment2.setType("传统香烟");
        equipment2.setPurchaseTime(LocalDateTime.now().toLocalDate());
        equipment2.setPrice(996L);
        equipment2.setDepartmentId(map.get(Constants.Ids.RandomNumeric).nextId());
        Result result2 = equipmentService.insert(equipment2);


        logger.info("code:{} info:{}", result1.getCode(), result1.getInfo());
    }

    @Test
    public void testGet() {
        Result all = equipmentService.getAll();
        logger.info("{}", all.getData());
        logger.info("code:{} info:{}", all.getCode(), all.getInfo());
    }
}
