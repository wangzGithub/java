package com.ego.practice.controller;

import com.ego.practice.bean.User;
import com.ego.practice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello")
@Api(tags = {"测试接口"}, description = "测试接口说明")
public class HelloController {

    private UserService userService;

    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ApiOperation(value = "返回name")
    public String sayHello(@RequestParam("name") String name) {
        return "the name you input are: " + name;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表")
    public List<User> getList() {
        return this.userService.getList();
    }

    @RequestMapping(value = "/addOne", method = RequestMethod.GET)
    @ApiOperation(value = "新增用户")
    public int addOne(@RequestParam("name") String name) {
        return this.userService.addOne(name);
    }
}
