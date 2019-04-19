package com.example.quick;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

/**
 * @author zyd
 * @date 2019/03/18
 */
public class TestController {

    private static final String BASE_URL = "http://127.0.0.1:8080/test/";

    @Test
    public void resolver() {
        String url = BASE_URL + "resolver" + "?appId=1-2-3";

        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap response = restTemplate.getForObject(url, LinkedHashMap.class);

        System.out.println(response);
    }

}
