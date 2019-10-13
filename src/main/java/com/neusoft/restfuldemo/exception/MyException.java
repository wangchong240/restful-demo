package com.neusoft.restfuldemo.exception;

import com.neusoft.restfuldemo.enums.ResultEnum;

/**
 * 自定义异常
 * @author Wang Chong at 2019-10-13 20:39
 * @since V1.0.0
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException() {}

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public MyException(ResultEnum resultEnum, Throwable throwable) {
        super(resultEnum.getMessage(),throwable);
        this.code = resultEnum.getCode();
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }
}
