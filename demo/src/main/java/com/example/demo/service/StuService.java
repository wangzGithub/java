package com.example.demo.service;

import com.example.demo.bean.Stu;
import com.example.demo.dao.StuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuService extends AbstractService<Stu, StuDao> {

    @Autowired
    private StuService(StuDao stuDao) {
        super(stuDao);
    }

    public int getCount() {
        return this.dao.getCount();
    }
}
