package com.neusoft.restfuldemo.enums;

import lombok.Getter;

/**
 * 返回结果枚举类
 * @author Wang Chong at 2019-10-13 19:16
 * @since V1.0.0
 */
@Getter
public enum ResultEnum {

    SUCCESS(200, "操作成功"),

    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
