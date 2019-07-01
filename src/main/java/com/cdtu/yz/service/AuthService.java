package com.cdtu.yz.service;

import com.cdtu.yz.entity.Auth;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/28 9:59
 * @Version 1.0
 */
public interface AuthService {

    /**
     * 返回所有的权限信息
     * @return
     */
    List<Auth> getAuthAll();
}
