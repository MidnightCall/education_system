package com.edu.utils.ids.policy;

import com.edu.utils.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @ClassName RandomNumeric
 * @Description 工具类生成 org.apache.commons.lang3.RandomStringUtils
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 11:28
 * @Version
 */
@Component
public class RandomNumeric implements IIdGenerator {

    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
