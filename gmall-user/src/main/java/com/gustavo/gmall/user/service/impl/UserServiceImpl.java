package com.gustavo.gmall.user.service.impl;

import com.gustavo.gmall.user.mapper.UserMapper;
import com.gustavo.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

}
