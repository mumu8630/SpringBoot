package com.nuc.mybatis.service;

import com.nuc.mybatis.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86186
 * @createDate:2022/11/1
 * @since
 */

public interface UserService {
    List<User> findAll();
    int delete(Integer id);
    int update(User user);
    int insert(User user);
    User findById(Integer id);
    List<User> findUsers(String name,String address);
}
