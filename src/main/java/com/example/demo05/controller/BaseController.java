package com.example.demo05.controller;

import com.example.demo05.mapper.UserMapper;
import com.example.demo05.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @Author: liuzw     Email :a1774214410@163.com
 * @Date: 2018/4/14 11:14
 */
public class BaseController {

    /**
     * 日志对象
     */
    protected Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     * 操作redis 工具类
     */
    @Autowired
    protected RedisUtil redisUtil;


    @Resource
    protected UserMapper userMapper;




}
