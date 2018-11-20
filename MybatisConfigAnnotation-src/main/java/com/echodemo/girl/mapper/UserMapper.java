package com.echodemo.girl.mapper;

import com.echodemo.girl.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，
 * 所以统一配置@MapperScan在扫描路径在application类中
 */
@Repository
public interface UserMapper {

    User getUserById(Integer id);

    List<User> getUserList();

    int add(User user);

    int update(@Param("id") int id, @Param("user") User user);

    int delete(Integer id);
}
