package com.baidu.service.Impl;

import com.baidu.dao.UserMapper;
import com.baidu.pojo.User;
import com.baidu.pojo.UserExample;
import com.baidu.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<User> list() {
        PageHelper.startPage(1,3);
        return userMapper.selectByExample(new UserExample());
    }
}
