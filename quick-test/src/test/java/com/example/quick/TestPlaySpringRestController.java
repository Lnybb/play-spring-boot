package com.example.quick;

import com.example.quick.controller.PlaySpringRestController;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;

/**
 * @author zyd
 * @date 2019/03/19
 * @see com.example.quick.controller.PlaySpringRestController
 */
public class TestPlaySpringRestController extends CommonTest {

    @Test
    public void testGetDemo1() {
        String url = BASE_URL + "play/rest/getDemo1";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("param1", "hello")
                .queryParam("param2", "world");

        LinkedHashMap response = restTemplate.getForObject(builder.build().encode().toUri(), LinkedHashMap.class);

        LOG.info("response: {}", response);
    }

    @Test
    public void testGetDemo2() {
        String url = BASE_URL + "play/rest/getDemo2";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("param1", "hello")
                .queryParam("param2", "world")
                .queryParam("appId", "this is app id");

        LinkedHashMap response = restTemplate.getForObject(builder.build().encode().toUri(), LinkedHashMap.class);

        LOG.info("response: {}", response);
    }

    @Test
    public void testGetDemo3() {
        String url = BASE_URL + "play/rest/getDemo3";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("param1", "1")
                .queryParam("param2", "2")
                //
                ;

        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(builder.build().encode().toUri(), LinkedHashMap.class);

        LOG.info("response: {}", response);
    }

    @Test
    public void testGetDemo4() {
        String url = BASE_URL + "play/rest/demo.get.4";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("param0", "0")
                .queryParam("param1", "1")
                .queryParam("param2", "2")
                .queryParam("param3", "3")
                .queryParam("param4", "4")
                //
                ;

        ResponseEntity<LinkedHashMap> response = restTemplate.getForEntity(builder.build().encode().toUri(), LinkedHashMap.class);

        LOG.info("response: {}", response);
    }

    @Test
    public void printHttpServletRequest() {
        String url = BASE_URL + "play/rest/print.http.request";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("param1", "hello")
                .queryParam("param2", "world")
                .queryParam("appId", "this is app id");

        PlaySpringRestController.PostModel model = new PlaySpringRestController.PostModel();
        model.setParam1("param1");
        model.setParam2("param2");

        HttpEntity<PlaySpringRestController.PostModel> requestEntity = new HttpEntity<>(model);

        ResponseEntity<LinkedHashMap> responseEntity = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.POST,
                requestEntity,
                LinkedHashMap.class);

        LOG.info("response: {}", responseEntity);
    }

}
