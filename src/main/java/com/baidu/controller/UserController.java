package com.baidu.controller;

import com.baidu.dao.UserMapper;
import com.baidu.pojo.Student;
import com.baidu.pojo.User;
import com.baidu.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 处理Ajax加注解@ResponseBody
 * 复合注解@RestController,返回的时候都是以流的形式
 */
@RestController
public class UserController {
    @Resource
    UserService userService;
    @GetMapping("/index")
    public List<User> index(){

        return userService.list();
    }
}
