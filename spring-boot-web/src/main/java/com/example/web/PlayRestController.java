package com.example.web;

import com.example.web.controller.RestControllerTestHelper;
import com.example.web.parameter.TobUser;
import com.example.web.parameter.TocUser;
import com.example.web.parameter.UserType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

/**
 * @author zyd
 * @date 2019/03/29
 */
@RestController
@RequestMapping("/play/rest")
public class PlayRestController implements RestControllerTestHelper {

    private static final Logger LOG = LoggerFactory.getLogger(PlayRestController.class);

    @GetMapping("data.binding.demo1")
    public ResponseEntity dataBindingDemo1(UserType userType,
                                           @RequestParam Map<String, Object> request) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);

        if (userType == UserType.TOC) {
            TocUser tocUser = mapper.convertValue(request, TocUser.class);
            LOG.info("toc user: {}", tocUser);
        } else if (userType == UserType.TOB) {
            TobUser tobUser = mapper.convertValue(request, TobUser.class);
            LOG.info("tob user: {}", tobUser);
        }

        return ResponseEntity.ok(request);
    }

}
