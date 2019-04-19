package com.example.quick.config;

import com.example.quick.component.CurrentAppResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author zyd
 * @date 2019/03/18
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CurrentAppResolver appResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(appResolver);
    }

}
