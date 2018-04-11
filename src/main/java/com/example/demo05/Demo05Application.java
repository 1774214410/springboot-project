package com.example.demo05;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.demo05.mapper"})
@EnableJpaRepositories(basePackages={"com.example.demo05.model"})
@ServletComponentScan
@EntityScan(basePackages={"com.example.demo05.model"})
//@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.example.demo05.mapper")
public class Demo05Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo05Application.class, args);
	}
}
