package com.example.demo05.controller;

import com.example.demo05.mapper.UserMapper;
import com.example.demo05.model.User;
import com.example.demo05.utils.JsonResult;
import com.example.demo05.utils.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping(value = "/user")
@Log4j
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/findAll")
    public JsonResult findAll(@RequestParam(name = "pageNum",defaultValue = "1",required = false) int pageNum,
                              @RequestParam(name = "pageSize",defaultValue = "2",required = false) int pageSize){
        PageHelper.startPage(pageNum,pageSize);

        log.//分页核心代码   就这一句
        List<User> userList = userMapper.findAll();
        User user = new User();

        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return new JsonResult(ResultCode.SUCCESS,pageInfo);
    }

//    @RequestMapping(value = "/findById")
//    public User findById(@RequestBody User user){
//        return userMapper.findById(user);
//    }



}
