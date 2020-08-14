package fun.xruo.lle.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandleAdvice {

    @ExceptionHandler(Exception.class)
    public RestBody handle(HttpServletRequest request, Exception e) {
        log.error("Request: {}", request);
        log.error("Exception: {}", e);
        return RestBody.failure(e);
    }

}
