package com.jk.service.User;

import com.jk.mapper.user.UserMapper;
import com.jk.model.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;



    public List<User> selectUserList(Integer page, Integer pageSize) {
        page = (page-1) * pageSize;
        return userMapper.selectUserList(page, pageSize);
    }

    public Integer selectUserListAlwaysSize() {
        return userMapper.selectUserListAlwaysSize();
    }

    public void DelectUser(String id) {
        userMapper.DelectUser(id);
    }

    public void addUser(User user) {
        userMapper.addUser( user);
    }
}
