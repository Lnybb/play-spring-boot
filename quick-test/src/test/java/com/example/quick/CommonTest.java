package com.example.quick;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author zyd
 * @date 2019/03/29
 */
public abstract class CommonTest {

    final Logger LOG = LoggerFactory.getLogger(this.getClass());

    static final String BASE_URL = "http://127.0.0.1:8080/";
    static RestTemplate restTemplate;

    @BeforeClass
    public static void init() {
        restTemplate = new RestTemplate();
    }

}
