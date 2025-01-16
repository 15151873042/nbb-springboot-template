package com.nbb.template.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nbb.template.framework.springmvc.converter.StringToDateConverter;
import com.nbb.template.framework.springmvc.converter.StringToLocalDateConverter;
import com.nbb.template.framework.springmvc.converter.StringToLocalDateTimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Iterator;
import java.util.List;


@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 删除原有的AbstractJackson2HttpMessageConverter
        Iterator<HttpMessageConverter<?>> iterator = converters.iterator();
        while (iterator.hasNext()) {
            HttpMessageConverter<?> messageConverter = iterator.next();
            if (messageConverter instanceof AbstractJackson2HttpMessageConverter) {
                iterator.remove();
            }
        }

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);
        converters.add(mappingJackson2HttpMessageConverter);
    }

    /**
     * 添加数据类型转换器，用于x-www-form-urlencoded传参
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToDateConverter());
        registry.addConverter(new StringToLocalDateConverter());
        registry.addConverter(new StringToLocalDateTimeConverter());
    }

}
