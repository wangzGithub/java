package com.ego.practice.service;

import com.ego.practice.bean.User;
import com.ego.practice.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getList() {
        return this.userDao.getList();
    }

    public int addOne(String name) {
        return this.userDao.addOne(name);
    }
}
