package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import org.apache.dubbo.config.annotation.Service;

/**
 * <pre>
 * Desc: UserService 的 provider;
 * Author:chenlu
 * Email:chenlu@ddjf.com.cn
 * Date:14:09 2018/2/8
 * </pre>
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUserName() {
        return "user name";
    }
}
