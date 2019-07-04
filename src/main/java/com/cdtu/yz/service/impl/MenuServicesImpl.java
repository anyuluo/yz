package com.cdtu.yz.service.impl;

import com.cdtu.yz.dao.MenuDao;
import com.cdtu.yz.entity.Menu;
import com.cdtu.yz.service.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 23:33
 * @Version 1.0
 */
@Service
public class MenuServicesImpl implements MenuServices {

    @Autowired
    MenuDao menuDao;

    @Override
    public List<Menu> findMenuByRole(Integer roleId) {
        return menuDao.selectMenuByRole(roleId);
    }

    @Override
    public List<Menu> getMenuAll() {
        return menuDao.getMenuAll();
    }
}
