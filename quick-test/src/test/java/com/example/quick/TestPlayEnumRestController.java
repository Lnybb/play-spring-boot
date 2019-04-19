package com.example.quick;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;

/**
 * @author zyd
 * @date 2019/03/29
 */
public class TestPlayEnumRestController extends CommonTest {

    @Test
    public void demo1() {
        String url = BASE_URL + "play/rest/enum/demo1";

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("productType", "TYPE1")
                .build();

        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(uriComponents.encode().toUri(), LinkedHashMap.class);

        LOG.info("response: {}", response);
    }

    @Test
    public void demo2() {
        String url = BASE_URL + "play/rest/enum/demo2";

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("productType", "TYPE1")
                .build();

        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(uriComponents.encode().toUri(), LinkedHashMap.class);

        LOG.info("response: {}", response);
    }
}
