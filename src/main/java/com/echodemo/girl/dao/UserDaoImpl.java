package com.echodemo.girl.dao;

import com.echodemo.girl.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(int id) {
        List<User> list = jdbcTemplate.query("select * from tb_user where id=?",new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        if(list != null && list.size() > 0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<User> getUserList() {
        List<User> list = jdbcTemplate.query("select * from tb_user", new Object[]{}, new BeanPropertyRowMapper<>(User.class));
        if(list != null && list.size() > 0){
            return list;
        }else {
            return null;
        }
    }

    @Override
    public int add(User user) {
        return jdbcTemplate.update("insert into tb_user(username, age, ctm) " +
                "values(?, ?, ?)",user.getUsername(),user.getAge(),user.getCtm());
    }

    @Override
    public int update(int id, User user) {
        return jdbcTemplate.update("update tb_user set username = ?, age = ? " +
                "where id = ?",user.getUsername(),user.getAge(),id);
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from tb_user where id = ?",id);
    }
}
