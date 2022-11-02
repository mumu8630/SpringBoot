package com.nuc.mybatis.service.impl;

import com.nuc.mybatis.mapper.UserMapper;
import com.nuc.mybatis.pojo.User;
import com.nuc.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86186
 * @createDate:2022/11/1
 * @since
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findUsers(String name, String address) {
        return userMapper.findUsers(name, address);
    }
}
