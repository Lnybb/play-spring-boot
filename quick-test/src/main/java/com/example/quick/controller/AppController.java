package com.example.quick.controller;

import com.example.quick.model.App;
import com.example.quick.annotion.CurrentApp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyd
 * @date 2019/03/18
 */
@RestController
@RequestMapping("/test")
public class AppController {

    @RequestMapping("resolver")
    public Object testResolver(@CurrentApp App app) {
        return app;
    }

}
