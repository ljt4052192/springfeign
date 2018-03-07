package com.jk.mapper.user;




import com.jk.model.User.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface UserMapper {



    @Select("SELECT * FROM t_user LIMIT #{page}, #{pageSize}")
    List<User> selectUserList(@Param("page") Integer page, @Param("pageSize") Integer pageSize);

    @Select("SELECT count(*) FROM t_user")
    Integer selectUserListAlwaysSize();

    @Delete("DELETE FROM t_user WHERE id = #{id}")
    void DelectUser(@Param("id") String id);

    @Insert("INSERT INTO t_user(" +
            "\t\t\t  name,\n" +
            "\t\t\tloginnumber,\n" +
            "\t\t\tpassword,\n" +
            "\t\t\tsex,\n" +
            "\t\t\tdetails\n" +
            "\t\t) VALUES(\n" +
            "\t\t\t#{user.name},\n" +
            "\t\t\t#{user.loginnumber},\n" +
            "\t\t\t#{user.password},\n" +
            "\t\t\t#{user.sex},\n" +
            "\t\t\t#{user.details}\n" +
            "\t\t)")
    void addUser(@Param("user") User user);
}
