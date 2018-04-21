package com.example.demo05.controller;

import com.example.demo05.model.User;
import com.example.demo05.utils.JsonResult;
import com.example.demo05.utils.RedisUtil;
import com.example.demo05.utils.ResultCode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    /**
     * 分页查找所有记录
     * @param pageNum
     * @param pageSize
     * @return
     */
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
        PageInfo<User> pageInfo = null;
        //RedisUtil redisUtil = new RedisUtil();
        if (redisUtil.hasKey("userList1")){
            List<User> userList = (List<User>) redisUtil.get("userList1");
            if (userList == null || userList.size() == 0){
                logger.info("输入参数  pageNum: {}, pageSize:{}",pageNum,pageSize);
                logger.info("******************************************");
                List<User> userList1 = userMapper.findAll();
                pageInfo = new PageInfo<>(userList1);
                redisUtil.set("userList1",userList1);
                return new JsonResult(ResultCode.SUCCESS,pageInfo);
            }
            logger.info("Redis中取得值  userList:{}",userList);
            pageInfo = new PageInfo<>(userList);
            return new JsonResult(ResultCode.SUCCESS,pageInfo);
        }
        logger.info("输入参数  pageNum: {}, pageSize:{}",pageNum,pageSize);
        logger.info("-----------------------------------------------");
        List<User> userList1 = userMapper.findAll();
        pageInfo = new PageInfo<>(userList1);
        redisUtil.set("userList1",userList1);
        logger.info("输出结果  userList:{}",userList1);
        return new JsonResult(ResultCode.SUCCESS,pageInfo);

    }





}
