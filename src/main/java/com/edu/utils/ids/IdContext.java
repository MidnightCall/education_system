package com.edu.utils.ids;


import com.edu.commons.Constants;
import com.edu.utils.ids.policy.RandomNumeric;
import com.edu.utils.ids.policy.ShortCode;
import com.edu.utils.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName IdContext
 * @Description Id策略模式上下文配置（在正式的完整的系统架构中，ID的生成会有单独的服务来完成，其他服务来调用ID生成接口即可）
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 11:29
 * @Version
 */
@Configuration
public class IdContext {

    /**
     * 创建ID生成策略对象，属于策略设计模式的使用方式
     * @param snowFlake 雪花算法，长码，大量
     * @param shortCode 日期算法，短码，少量，全局唯一需要自己保证
     * @param randomNumeric 随机算法，短码，大量，全局唯一需要自己保证
     * @return IIdGenerator 实现类
     */
    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode, RandomNumeric randomNumeric){
        Map<Constants.Ids, IIdGenerator> idGeneratorMap = new HashMap<>(8);
        idGeneratorMap.put(Constants.Ids.SnowFlake, snowFlake);
        idGeneratorMap.put(Constants.Ids.ShortCode, shortCode);
        idGeneratorMap.put(Constants.Ids.RandomNumeric, randomNumeric);
        return idGeneratorMap;
    }
}
