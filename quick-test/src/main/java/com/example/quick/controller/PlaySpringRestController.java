package com.example.quick.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyd
 * @date 2019/03/19
 */
@RestController
@RequestMapping("/play/rest")
public class PlaySpringRestController {

    private static final Logger LOG = LoggerFactory.getLogger(PlaySpringRestController.class);

    @GetMapping("getDemo1")
    public Object getDemo1(GetModel1 request) {
        LOG.info("打印 get 请求参数：{}", request);
        return request;
    }

    @GetMapping("getDemo2")
    public Object getDemo2(@RequestParam(required = false) String appId, GetModel1 request) {
        LOG.info("打印 get 请求参数 appId：{}", appId);
        LOG.info("打印 get 请求参数：{}", request);
        return request;
    }

    @GetMapping("getDemo3")
    public void getDemo3(GetModel1 model1,
                         GetModel2 model2) {
        LOG.info("打印 get 请求参数 model 1：{}", model1);
        LOG.info("打印 get 请求参数 model 2：{}", model2);
    }

    @GetMapping("demo.get.4")
    public void getDemo4(AbstractModel model) {
        GetModel1 model1 = (GetModel1) model;
        GetModel2 model2 = (GetModel2) model;

        LOG.info("打印 get 请求参数 model 1：{}", model1);
        LOG.info("打印 get 请求参数 model 2：{}", model2);
    }

    @RequestMapping("print.http.request")
    public void printHttpRequest(HttpServletRequest request) throws IOException {
        LOG.info("http header: {}", getHeaders(request));
        LOG.info("http parameters: {}", getQueryParameters(request));
        LOG.info("http post body: {}", getBodyParameters(request));
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(5);

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            map.put(headerName, headerValue);
        }

        return map;
    }

    private Map<String, String> getQueryParameters(HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<>(5);

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            map.put(name, value);
        }

        return map;
    }

    private Map<String, String> getBodyParameters(HttpServletRequest request) throws IOException {
        Map<String, String> map = null;

        String contentType = request.getContentType();
        if (MediaType.APPLICATION_JSON_VALUE.equals(contentType) ||
                MediaType.APPLICATION_JSON_UTF8_VALUE.equals(contentType)) {

            String jsonStr = IOUtils.toString(request.getReader());
            map = new ObjectMapper().readValue(jsonStr, new TypeReference<Map<String, String>>() {
            });

        }

        return map;
    }

    @Data
    static class AbstractModel {
        private String param0;
    }

    @Data
    public static class GetModel1 extends AbstractModel {
        private String param1;

        private String param2;
    }

    @Data
    public static class GetModel2 extends AbstractModel {
        private String param3;

        private String param4;
    }

    @Data
    public static class PostModel {
        private String param1;

        private String param2;
    }

}
