package com.example.demo.dao;

import com.example.demo.bean.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StuDao extends BaseDao<Stu> {

    @Override
    List<Stu> getAll();

    int getCount();
}
