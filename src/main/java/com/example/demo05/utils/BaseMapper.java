package com.example.demo05.utils;

//import tk.mybatis.mapper.common.Mapper;
//import tk.mybatis.mapper.common.MySqlMapper;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseMapper<T> extends JpaRepository<T,Integer> {

}
