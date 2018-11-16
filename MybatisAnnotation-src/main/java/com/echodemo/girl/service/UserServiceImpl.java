package com.echodemo.girl.service;

import com.echodemo.girl.bean.User;
import com.echodemo.girl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id){
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int update(int id, User user) {
        return userMapper.update(id,user);
    }

    @Override
    public int delete(int id) {
        return userMapper.delete(id);
    }
}
