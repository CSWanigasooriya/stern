package com.flaze.stern.interceptors;

import com.flaze.stern.services.LoggingService;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {


    final private LoggingService loggingService;


    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {

        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name()) && request.getMethod().equals(HttpMethod.GET.name())) {
            loggingService.logRequest(request, null);
        }

        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest httpServletRequest, @NonNull HttpServletResponse httpServletResponse, @NonNull Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest httpServletRequest, @NonNull HttpServletResponse httpServletResponse,@NonNull  Object o, Exception e) {

    }
}