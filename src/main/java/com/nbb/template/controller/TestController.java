package com.nbb.template.controller;

import cn.hutool.core.map.MapUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nbb.template.AjaxResult;
import com.nbb.template.domain.DateTestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/date")
    public AjaxResult dateTest(DateTestDTO dto) {
        redisTemplate.opsForValue().set("dto", dto);
        ValueOperations<String, DateTestDTO> operation = redisTemplate.opsForValue();
        DateTestDTO result = operation.get("dto");
        return AjaxResult.success(result);
    }

    @RequestMapping("/test")
    public AjaxResult test() {
        return AjaxResult.success();
    }
}
