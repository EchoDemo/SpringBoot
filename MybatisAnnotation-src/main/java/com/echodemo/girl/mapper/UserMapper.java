package com.echodemo.girl.mapper;

import com.echodemo.girl.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，
 * 所以统一配置@MapperScan在扫描路径在application类中
 */
public interface UserMapper {

    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    User getUserById(int id);

    @Select("SELECT * FROM tb_user")
    List<User> getUserList();

    @Insert("INSERT INTO tb_user(username, age, ctm) VALUES(#{username}, #{age}, now())")
    int add(User user);

    @Update("UPDATE tb_user SET username = #{user.username}, age = #{user.age} WHERE id = #{id}")
    int update(@Param("id") Integer id, @Param("user") User user);

    @Delete("DELETE FROM tb_user WHERE id = #{id}")
    int delete(int id);
}
