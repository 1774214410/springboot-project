package com.example.demo05.controller;

import com.example.demo05.mapper.UserMapper;
import com.example.demo05.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/findAll")
    public List<User> findAll(){
        //PageHelper.startPage(pageNum,pageSize);       //分页核心代码   就这一句
        List<User> userList = userMapper.
        //PageInfo<User> pageInfo = new PageInfo<>(userList);
        return userList;
    }

//    @RequestMapping(value = "/findById")
//    public User findById(@RequestBody User user){
//        return userMapper.findById(user);
//    }



}
