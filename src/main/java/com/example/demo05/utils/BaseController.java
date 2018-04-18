package com.example.demo05.utils;

import com.example.demo05.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @Author: liuzw     Email :a1774214410@163.com
 * @Date: 2018/4/14 11:14
 */
public class BaseController {

    protected Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    protected UserMapper userMapper;




}
