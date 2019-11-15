package com.neusoft.restfuldemo.vo;

import com.neusoft.restfuldemo.enums.ResultEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 统一结果包装类
 * @author Wang Chong at 2019-10-13 19:12
 * @since V1.0.0
 */
@Data
public class ResultVO implements Serializable {

    /**
     * 返回状态码
     */
    private Integer code;

    /**
     * 返回信息描述
     */
    private String message;

    /**
     * 返回值
     */
    private Object data;

    public ResultVO() {}

    /**
     * 有参构造器
     */
    public ResultVO(ResultEnum resultEnum, Object data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }

    /**
     * 返回成功
     */
    public static ResultVO success(Object data) {
        return new ResultVO(ResultEnum.SUCCESS, data);
    }

    /**
     * 返回成功
     */
    public static ResultVO success(ResultEnum resultEnum) {
        return new ResultVO(resultEnum, null);
    }

    /**
     * 返回失败
     */
    public static ResultVO failure(ResultEnum resultEnum, Object data) {
        return new ResultVO(resultEnum, data);
    }

    /**
     * 返回失败
     */
    public static ResultVO failure(ResultEnum resultEnum) {
        return new ResultVO(resultEnum, null);
    }

}
