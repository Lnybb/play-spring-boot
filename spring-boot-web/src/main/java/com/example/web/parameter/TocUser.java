package com.example.web.parameter;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zyd
 * @date 2019/03/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TocUser extends User {

    private String toc;

}
