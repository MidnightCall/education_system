package com.edu.service;

import com.edu.commons.Result;
import com.edu.entity.GrowthRecord;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName GrowthRecordTest
 * @Description TODO
 * @Author LucasWang
 * @Date 2023/7/15 20:06:17
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GrowthRecordTest {

    @Resource
    private IGrowthRecordService growthRecordService;

    @Test
    public void testInsert(){
        GrowthRecord growthRecord = new GrowthRecord();
        growthRecord.setStuId(1679764887720054786L);
        growthRecord.setYear(2022);
        growthRecord.setLearning("1!5!");
        Result result = growthRecordService.insert(growthRecord);
        log.info("code : {} info : {}", result.getCode(), result.getInfo());

        //growthRecord.setStuId(1L);
        growthRecord.setLearning("");
        result = growthRecordService.insert(growthRecord);
        log.info("code : {} info : {}", result.getCode(), result.getInfo());
    }

    @Test
    public void testGetByStudentId(){
        Result result = growthRecordService.getByStudentId(1679764887720054786L);
        for(GrowthRecord growthRecord : (List<GrowthRecord>) result.getData()){
            log.info("{}, ", growthRecord);
        }
    }
}
