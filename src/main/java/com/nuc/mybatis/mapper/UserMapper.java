package com.nuc.mybatis.mapper;

import com.nuc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author 86186
 * @createDate:2022/11/1
 * @since
 */
@Mapper
public interface UserMapper {
    List<User> findAll();
    int insert(User user);
    int delete(Integer id);
    int update( User user);
    User findById(Integer id);
    List<User> findUsers(@Param("user_name") String name, @Param("address") String address);
}
