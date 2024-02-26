package com.edu.config;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RateLimiterConfig
 * @Description
 * @Author kojikoji 1310402980@qq.com
 * @Date 2024/2/26 16:00
 * @Version
 */

public class RateLimiterConfig {
    public static Map<String, RateLimiter> rateLimiterMap = Collections.synchronizedMap(new HashMap<String, RateLimiter>());
}
