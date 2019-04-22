package com.example.swagger.controller.parameter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zyd
 * @date 2019/04/20
 */
@Data
public class SaveRequest {

    @ApiModelProperty(value = "标识", notes = "notes")
    private String id;


}
