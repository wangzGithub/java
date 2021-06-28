package com.example.demo.controller;

import com.example.demo.bean.Page;
import com.example.demo.bean.Stu;
import com.example.demo.service.StuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {

    private final StuService stuService;

    @RequestMapping("/getStuAll")
    public Page<Stu> getAll() {
        return this.stuService.getAll();
    }

    @RequestMapping("/getStuCount")
    public int getStuCount() {
        return this.stuService.getCount();
    }
}
