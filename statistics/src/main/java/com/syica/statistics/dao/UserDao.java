package com.syica.statistics.dao;

import com.syica.statistics.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserDao {

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User getUserById(int id);

    int addUser(User user);
}
