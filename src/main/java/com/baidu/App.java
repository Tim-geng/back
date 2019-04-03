package com.baidu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * 1.要想启动这个启动类加注解@SpringBootApplication
 * 2.扫描数据包加注解@MapperScan
 */
@SpringBootApplication
@MapperScan("com.baidu.dao")
public class App {
    public static void main(String[] args) {
//        运行的方法--启动类App
        SpringApplication.run(App.class);
    }
}
