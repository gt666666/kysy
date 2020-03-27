package com.sygs.config.interceptor;


import com.sygs.config.convert.DateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Resource
    private RequestMappingHandlerAdapter handlerAdapter;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AxiosInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
//    }
    @PostConstruct
    public void initEditableAvlidation() {
        ConfigurableWebBindingInitializer initializer =
                (ConfigurableWebBindingInitializer) handlerAdapter.getWebBindingInitializer();
        GenericConversionService genericConversionService =
                (GenericConversionService) initializer.getConversionService();
        genericConversionService.addConverter(new DateConverter());

    }
}