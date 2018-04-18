package com.example.demo05.controller;

import com.example.demo05.mapper.UserMapper;
import com.example.demo05.model.User;
import com.example.demo05.utils.BaseController;
import com.example.demo05.utils.JsonResult;
import com.example.demo05.utils.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
public class UserController extends BaseController {

    
    @ApiOperation(value="查找所有用户",produces = "application/json")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNum", value = "当前页码", required = false, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页面记录数", required = false, paramType = "query", dataType = "int")
    })
    @RequestMapping(value = "/findAll")
    public JsonResult findAll(@RequestParam(name = "pageNum",defaultValue = "1",required = false) int pageNum,
                              @RequestParam(name = "pageSize",defaultValue = "2",required = false) int pageSize){
        PageHelper.startPage(pageNum,pageSize);//分页核心代码   就这一句
        //logger.info(Thread.currentThread().getStackTrace()[1].getMethodName()+"方法开始调用   输入参数：pageNum "+pageNum+";pageSize "+pageSize);
        logger.info("输入参数  pageNum: {}, pageSize:{}",pageNum,pageSize);
        List<User> userList = userMapper.findAll();
        User user = new User();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        //logger.info(Thread.currentThread().getStackTrace()[1].getMethodName()+"方法结束调用");
        logger.info("输出结果  userList:{}",userList);
        return new JsonResult(ResultCode.SUCCESS,pageInfo);
    }

//    @RequestMapping(value = "/findById")
//    public User findById(@RequestBody User user){
//        return userMapper.findById(user);
//    }



}
