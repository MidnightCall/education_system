package com.edu.config;

import com.edu.commons.JacksonObjectMapper;
import com.edu.utils.LoginInterceptor;
import com.edu.utils.RefreshTokenInterceptor;
import io.swagger.annotations.Api;
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
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
@EnableSwagger2
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(new JacksonObjectMapper());
        converters.add(0, mappingJackson2HttpMessageConverter);
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //token刷新拦截器
//        registry.addInterceptor(new RefreshTokenInterceptor(stringRedisTemplate)).addPathPatterns("/**").order(0);
//        // 登录拦截器
//        registry.addInterceptor(new LoginInterceptor())
//                .excludePathPatterns(
//                        "/user/login",
//                        "/user/register"
//                ).order(1);
//    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    //基本信息的配置，信息会在api文档上显示
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("education接口文档")
                .description("edu-sys相关接口的文档")
                .termsOfServiceUrl("/hello")
                .version("1.0")
                .build();
    }

}

