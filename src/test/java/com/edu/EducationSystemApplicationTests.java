package com.edu;

import com.edu.commons.Constants;
import com.edu.utils.ids.IIdGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
class EducationSystemApplicationTests {

    private Logger logger = LoggerFactory.getLogger(EducationSystemApplicationTests.class);

    @Resource
    private Map<Constants.Ids, IIdGenerator> map;

    @Test
    public void testId() {
        long shortId = map.get(Constants.Ids.ShortCode).nextId();
        long snowFlakeId = map.get(Constants.Ids.SnowFlake).nextId();
        long randomId = map.get(Constants.Ids.RandomNumeric).nextId();
        long redisId = map.get(Constants.Ids.RedisIdWorker).nextId();
        logger.info("ShortCode:{}", shortId);
        logger.info("SnowFlakeCode:{}", snowFlakeId);
        logger.info("randomId:{}", randomId);
        logger.info("redisId:{}", redisId);
    }

    @Test
    void contextLoads() {
    }

}
