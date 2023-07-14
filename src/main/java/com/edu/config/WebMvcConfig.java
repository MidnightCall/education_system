package com.edu.config;

import com.edu.commons.JacksonObjectMapper;
import com.edu.utils.LoginInterceptor;
import com.edu.utils.RefreshTokenInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName WebMvcConfig
 * @Description Spring MVC配置文件
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:33
 * @Version
 */

@Slf4j
@Configuration
@EnableTransactionManagement
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(new JacksonObjectMapper());
        converters.add(0, mappingJackson2HttpMessageConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //token刷新拦截器
        registry.addInterceptor(new RefreshTokenInterceptor(stringRedisTemplate)).addPathPatterns("/**").order(0);
        // 登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(
                        "/user/login",
                        "/user/register"
                ).order(1);
    }

}

