package com.edu.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    @Bean
    public RedissonClient redissonClient(){
        // 配置类
        Config config = new Config();
        // 添加redis地址，可以使用config.useClusterServers()添加集群地址
        config.useSingleServer().setAddress("redis://124.220.155.208:6379").setPassword("wch20030313");
        // 创建客户端
        return Redisson.create(config);
    }
}
