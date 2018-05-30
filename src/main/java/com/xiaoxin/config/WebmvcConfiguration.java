package com.xiaoxin.config;

import com.google.gson.Gson;
import com.xiaoxin.validator.model.Result;
import com.xiaoxin.validator.model.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * 所有的内容协商器、拦截器、统一异常处理、messageResolver、跨域配置等都可以在这里配置
 * @Auther zhangyongxin
 * @date 2018/5/30 下午4:56
 */
@Slf4j
@Configuration
public class WebmvcConfiguration implements WebMvcConfigurer {

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add((httpServletRequest, httpServletResponse, handler, exception) -> {
            Result result = ResultGenerator.genFailResult(exception.getMessage());
            try {
                httpServletResponse.getWriter().write(new Gson().toJson(result));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ModelAndView();
        });
    }
}
