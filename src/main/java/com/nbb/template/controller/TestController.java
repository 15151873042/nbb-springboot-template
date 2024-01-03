package com.nbb.template.controller;

import com.nbb.template.AjaxResult;
import com.nbb.template.domain.DateTestDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("/date")
    public AjaxResult dateTest(@RequestBody DateTestDTO dto) {
        return AjaxResult.success(dto);
    }

    @RequestMapping("/test")
    public AjaxResult test() {
        return AjaxResult.success();
    }
}
