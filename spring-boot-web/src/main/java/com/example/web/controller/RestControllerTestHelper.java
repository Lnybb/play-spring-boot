package com.example.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * @author zyd
 * @date 2019/03/29
 */
public interface RestControllerTestHelper {

    String BASE_URL = "http://127.0.0.1:8080/play/rest/";

    default RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    default <T> ResponseEntity<T> get(String url, Map<String, Object> queryParameter, Class<T> responseType) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL + url);
        for (Map.Entry<String, Object> entry : queryParameter.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        UriComponents uriComponents = builder.build();
        ResponseEntity<T> responseEntity = getRestTemplate().getForEntity(uriComponents.toUri(), responseType);
        System.out.println(responseEntity);

        return responseEntity;
    }

}
