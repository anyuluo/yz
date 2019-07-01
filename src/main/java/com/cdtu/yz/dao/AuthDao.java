package com.cdtu.yz.dao;

import com.cdtu.yz.entity.Auth;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 权限管理数据访问接口
 * @Author: An
 * @Date: 2019/6/28 9:59
 * @Version 1.0
 */
@Component
public interface AuthDao {
    /**
     * 获取所有的权限信息
     *
     * @return
     */
    List<Auth> getAuthAll();
}
