package com.edu.utils.ids.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.edu.utils.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName SnowFlake
 * @Description hutool 工具包下的雪花算法 https://github.com/looly/hutool
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 11:28
 * @Version
 */
@Component
public class SnowFlake implements IIdGenerator {
    private Snowflake snowFlake;

    @PostConstruct
    public void init(){
        // 0~31位，可以采用配置的方法使用
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        }catch (Exception e){
            workerId = NetUtil.getLocalhost().hashCode();
        }

        workerId = workerId >> 16 & 31;
        long dataCenterId = 1L;
        snowFlake = IdUtil.createSnowflake(workerId, dataCenterId);
    }


    @Override
    public long nextId() {
        return snowFlake.nextId();
    }
}
