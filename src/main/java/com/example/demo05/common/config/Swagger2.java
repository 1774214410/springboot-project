package com.example.demo05.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: liuzw     Email :a1774214410@163.com
 * @Date: 2018/4/18 23:03
 */
@EnableSwagger2
@Configuration
public class Swagger2 {

    @Value("${basePackages}")
    private String basePackages;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为接口包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.demo05.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot使用 Swagger2 构建RestFul API")
                //创建人
                .contact(new Contact("liuzw", "http://localhost:8888/swagger-ui.html", "a1774214410@163.com"))
                //版本号
                .version("1.0")
                //描述
                .description("SpringBootDemo测试工程接口文档")
                .build();
    }
}
