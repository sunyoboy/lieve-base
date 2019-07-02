package com.lieve.base.mapper;

import com.lieve.base.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunlijiang
 * @date 2019/6/29
 */
@Mapper
public interface UserMapper {

    @Insert({"insert into user(id, name, age) values(#{user.id}, #{user.name}, #{user.age})"})
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(@Param("user") User user);
}
