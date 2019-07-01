package com.cdtu.yz.service.impl;

import com.cdtu.yz.dao.AuthDao;
import com.cdtu.yz.entity.Auth;
import com.cdtu.yz.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/28 10:00
 * @Version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthDao authDao;

    @Override
    public List<Auth> getAuthAll() {
        return authDao.getAuthAll();
    }
}
