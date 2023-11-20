package com.nbb.template.framework.springmvc;

import cn.hutool.core.date.DateUtil;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * x-www-form-urlencoded传参，date类型数据转换适配
 */
public class StringToDateConverter implements Converter<String, Date>{

    @Override
    public Date convert(String source) {

        return DateUtil.parse(source);
    }

}
