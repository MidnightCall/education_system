package com.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description 网络环境测试接口，已废弃
 * @Author kojikoji 1310402980@qq.com
 * @Date 2023/7/13 15:42
 * @Version
 */
@Deprecated
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test() {
        return "hello";
    }

}
