package com.echodemo.girl.service;

import com.echodemo.girl.bean.User;
import com.echodemo.girl.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int update(int id, User user) {
        return userDao.update(id,user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }
}
