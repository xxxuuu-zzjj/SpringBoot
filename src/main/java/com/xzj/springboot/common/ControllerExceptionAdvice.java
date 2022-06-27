package com.xzj.springboot.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzj.springboot.annotation.NotControllerResponseAdvice;
import com.xzj.springboot.common.exception.APIException;
import com.xzj.springboot.common.response.Response;
import com.xzj.springboot.common.response.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @RestControllerAdvice 增强所有 @RestController
 *  @ExceptionHandler 注解 拦截到对应的异常。
 *
 * ResponseBodyAdvice 对返回体进行增强，自动包装
 * 也可以不使用，每次返回 new Response
 */
@Slf4j
@RestControllerAdvice(basePackages = {"com.xzj.springboot"})
public class ControllerExceptionAdvice implements ResponseBodyAdvice<Object> {

    @ExceptionHandler({BindException.class})
    public Response MethodArgumentNotValidExceptionHandler(BindException e){
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new Response(ResponseCode.VALIDATE_ERROR, objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public Response APIExceptionHandler(APIException e) {
        log.error(e.getMessage(), e);
        return new Response(e.getCode(), e.getMsg(), e.getMessage());
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 返回类型是Response类型，或者添加注解 @NotControllerResponseAdvice都不进行包装
        return !(methodParameter.getParameterType().isAssignableFrom(Response.class)
                || methodParameter.hasMethodAnnotation(NotControllerResponseAdvice.class));
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        // String类型不能直接包装
        // 此处String有问题 前端接收中文乱码=？？？？ 可能前端需要做些设置
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVo里后转换为json串进行返回
                return objectMapper.writeValueAsString(new Response(data));
            } catch (JsonProcessingException e) {
                throw new APIException(ResponseCode.RESPONSE_PACK_ERROR, e.getMessage());
            }
        }
        // 否则直接包装成ResultVo返回
        return new Response(data);
    }

}
