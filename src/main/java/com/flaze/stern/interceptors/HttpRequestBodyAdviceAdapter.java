package com.flaze.stern.interceptors;

import com.flaze.stern.services.LoggingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;


@RequiredArgsConstructor
@ControllerAdvice
public class HttpRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

    final private LoggingService loggingService;

    final private HttpServletRequest httpServletRequest;

    @Override
    public boolean supports(@NonNull MethodParameter methodParameter, @NonNull Type type, @NonNull Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public @NonNull Object afterBodyRead(@NonNull Object body, @NonNull HttpInputMessage inputMessage, @NonNull MethodParameter parameter, @NonNull Type targetType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        loggingService.logRequest(httpServletRequest, body);
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}