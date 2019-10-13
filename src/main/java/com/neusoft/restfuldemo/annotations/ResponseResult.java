package com.neusoft.restfuldemo.annotations;

import java.lang.annotation.*;

/**
 * 标注控制层返回的结果是否需要包装
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ResponseResult {
}
