package cn.edu.idea.interceptor;

import cn.edu.idea.consts.Consts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回结果封装
 * @author chenrui
 * @date 2022/11/23
 */
@Slf4j
@RestControllerAdvice(basePackages = "cn.edu.idea.api")
public class ResultInterceptor implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return !Consts.ready;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return null;
    }
}
