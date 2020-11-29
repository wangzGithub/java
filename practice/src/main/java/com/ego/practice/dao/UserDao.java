package com.ego.practice.dao;

import com.ego.practice.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> getList();

    int addOne(String name);
}
