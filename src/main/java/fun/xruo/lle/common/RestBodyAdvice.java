package fun.xruo.lle.common;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一返回体包装器
 *
 * @author felord.cn
 * @since 14:58
 **/
@RestControllerAdvice
public class RestBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 如果为空 返回一个不带数据的空返回体       
        if (o == null) {
            return RestBody.ok();
        }
        // 如果 RestBody 的 父类 是 返回值的父类型 直接返回 
        // 方便我们可以在接口方法中直接返回RestBody
        if (RestBody.class.isAssignableFrom(o.getClass())) {
            return o;
        }
        // 进行统一的返回体封装
        return RestBody.ok(o);
    }
}
