package com.nbb.template.controller;

import cn.hutool.db.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.nbb.template.AjaxResult;
import com.nbb.template.domain.DateTestDTO;
import com.nbb.template.domain.DictTypeDO;
import com.nbb.template.mapper.DictTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    DictTypeMapper dictTypeMapper;


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

    @RequestMapping("/list")
    public AjaxResult list() {
        PageDTO<DictTypeDO> dictTypeDOPageDTO = dictTypeMapper.selectPage(new PageDTO<>(), new LambdaQueryWrapper<>());
        return AjaxResult.success(dictTypeDOPageDTO);
    }
}
