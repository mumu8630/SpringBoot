package com.nuc.mybatis;

import com.nuc.mybatis.mapper.UserMapper;
import com.nuc.mybatis.pojo.User;
import com.nuc.mybatis.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
    }

    @Test
    public void testFindAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public  void testInsert() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"王思博","2022-3-8","1","乡宁");
        int insert = mapper.insert(user);
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testMapper(){
        //List<User> users = userMapper.findAll();
        //for (User user : users) {
        //    System.out.println(user);
        //}
        System.out.println(userMapper.insert(new User(null, "王思博", "2022-3-6", "1", "大兴安岭")));

    }

    @Test
    public void testService(){
        //List<User> users = userService.findAll();
        //for (User user : users) {
        //    System.out.println(user);
        //}
        //System.out.println(userService.insert(new User(null, "张力文", "2000-3-5", "1", "狗熊岭")));
        //System.out.println(userService.update(new User(31, "邢栋", "2010-3-6", "1", "赛尔号")));
        System.out.println(userService.delete(27));
    }




}
