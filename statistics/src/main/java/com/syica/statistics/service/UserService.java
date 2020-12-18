package com.syica.statistics.service;

import com.syica.statistics.bean.User;
import com.syica.statistics.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findByUsernameAndPassword(String username, String password) {
        return this.userDao.findByUsernameAndPassword(username, password);
    }

    public User getUserById(String id) {
        return this.userDao.getUserById(Integer.parseInt(id));
    }

    public int addUser(User user) {
        return this.userDao.addUser(user);
    }
}
