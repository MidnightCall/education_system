package com.edu.utils.ids.policy;

import cn.hutool.core.util.StrUtil;
import com.edu.utils.ids.IIdGenerator;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName RedisIdWorker
 * @Description 日期加上redis的自增序列号生成
 * @Author Lucas Wang
 * @Date 2023/7/14 15:28
 * @Version
 */

@Component
public class RedisIdWorker implements IIdGenerator {
    /**
     * 序列号的位数
     */
    private static final int COUNT_BITS = 10;

    private StringRedisTemplate stringRedisTemplate;

    public RedisIdWorker(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public long nextId() {
        // 1.获取当前时间
        LocalDateTime now = LocalDateTime.now();

        // 2.生成序列号
        // 2.1.获取当前日期
        String date = now.format(DateTimeFormatter.ofPattern("yyMMdd"));
        // 2.2.获得自增长的序列号
        long count = stringRedisTemplate.opsForValue().increment("icr:department:" + date);
        // 3.拼接并返回
        return Long.parseLong(date) << COUNT_BITS | count;
    }


}
