package com.example.quick.controller;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyd
 * @date 2019/03/29
 */
@RestController
@RequestMapping("/play/rest/enum")
public class PlayEnumRestController {

    private static final Logger LOG = LoggerFactory.getLogger(PlayEnumRestController.class);

    @RequestMapping("demo1")
    public void demo1(ProductType productType) {
        LOG.info("name: {}, code: {}, value: {}", productType.name(), productType.getCode(), productType.getDescription());
    }

    @RequestMapping("demo2")
    public void demo2(EnumRequest request) {
        LOG.info("request: {}", request);
    }

    @Data
    static class EnumRequest {
        ProductType productType;
    }

}
