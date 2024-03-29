package com.edu;

import com.alibaba.fastjson.JSON;
import com.edu.commons.Constants;
import com.edu.entity.User;
import com.edu.utils.ids.IIdGenerator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
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
        logger.info("ShortCode:{}", shortId);
        logger.info("SnowFlakeCode:{}", snowFlakeId);
        logger.info("randomId:{}", randomId);
    }

    @Test
    public void testUser() {
        User user = new User();
        user.setUsername("zjc");
        user.setPassword("123456");
        logger.info("user: {}", JSON.toJSON(user));
    }


}
