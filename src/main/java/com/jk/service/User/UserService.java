package com.jk.service.User;

import com.jk.model.User.User;

import java.util.List;


public interface UserService {

    /**
     *
     * @return 查询出的用户列表
     * @param page 当前页
     * @param pageSize 每页条数
     */
    List<User> selectUserList(Integer page, Integer pageSize);

    /**
     *
     * @return 查询出的用户列表的总条数
     */
    Integer selectUserListAlwaysSize();

    /**
     *
     * @param id 需要删除的用户ID
     */
    void DelectUser(String id);

    /**
     *
     * @param user 需要新增的用户信息
     */
    void addUser(User user);

}
