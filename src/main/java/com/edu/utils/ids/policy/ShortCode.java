package com.edu.utils.ids.policy;

import com.edu.utils.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

/**
 * @ClassName ShortCode
 * @Description 短码生成策略，仅支持很小的调用量，用于生成活动配置类编号，保证全局唯一
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 11:28
 * @Version
 */

@Component
public class ShortCode implements IIdGenerator {
    @Override
    public long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 打乱排序：2020年为准 + 小时 + 周期 + 日 + 三位随机数
        StringBuilder idStr = new StringBuilder();
        idStr.append(year - 2020);
        idStr.append(hour);
        idStr.append(String.format("%02d", week));
        idStr.append(day);
        idStr.append(String.format("%03d", new Random().nextInt(1000)));

        return Long.parseLong(idStr.toString());
    }
}
