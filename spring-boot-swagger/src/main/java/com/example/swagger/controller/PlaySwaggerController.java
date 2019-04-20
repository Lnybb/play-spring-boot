package com.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyd
 * @date 2019/04/20
 */
@Api(tags = "主接口")
@RestController
@RequestMapping("/play.swagger")
public class PlaySwaggerController {

    @ApiOperation(value = "保存", notes = "执行保存")
    @PostMapping("save")
    public ResponseEntity<?> save() {
        return ResponseEntity.ok("save success");
    }

}
