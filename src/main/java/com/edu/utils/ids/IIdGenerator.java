package com.edu.utils.ids;

/**
 * @ClassName IIdGenerator
 * @Description 生成ID接口
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/14 11:29
 * @Version
 */

public interface IIdGenerator {
    /**
     * 获取ID，目前有两种实现方式
     * 1. 雪花算法，用于生成单号
     * 2. 日期算法， 用于生成活动编号类，特定是生成数字串较短，但指定时间不能生产太多
     * 3. 随机算法，用于生成策略ID
     */
    long nextId();
}
