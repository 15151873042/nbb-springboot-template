package com.nbb.template.framework.springmvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * x-www-form-urlencoded传参，date类型数据转换适配
 */
public class StringToDateConverter implements Converter<String, Date>{

    @Override
    public Date convert(String source) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
