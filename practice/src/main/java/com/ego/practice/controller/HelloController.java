package com.ego.practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Api(tags = {"测试接口"}, description = "测试接口说明")
public class HelloController {

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ApiOperation(value = "返回name")
    public String sayHello(@RequestParam("name") String name) {
        return "the name you input are: " + name;
    }
}
