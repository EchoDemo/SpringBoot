package com.echodemo.girl.dao;

import com.echodemo.girl.bean.User;

import java.util.List;

public interface UserDao {

    User getUserById(int id);

    List<User> getUserList();

    int add(User user);

    int update(int id,User user);

    int delete(int id);
}
