package com.example.demo05.mapper;

import com.example.demo05.model.User;
//import com.example.demo05.utils.BaseMapper;
import com.example.demo05.utils.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper  extends BaseMapper<User>{


    User findById(@Param("id") int id);


}
