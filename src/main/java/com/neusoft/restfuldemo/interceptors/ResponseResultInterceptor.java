package com.neusoft.restfuldemo.interceptors;

import com.neusoft.restfuldemo.vo.ResultVO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 控制层返回结果包装拦截器
 * @author Wang Chong at 2019-10-13 20:01
 * @since V1.0.0
 */
@ControllerAdvice
public class ResponseResultInterceptor implements ResponseBodyAdvice<Object> {

    /**
     * 用于标记那些方法需要拦截处理
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * 拦截处理逻辑
     */
    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ResponseEntity.ok().header("你好");
        return ResultVO.success(o);
    }
}
