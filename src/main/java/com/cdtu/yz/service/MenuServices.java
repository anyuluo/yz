package com.cdtu.yz.service;

import com.cdtu.yz.entity.Menu;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 23:31
 * @Version 1.0
 */
public interface MenuServices {

    /**
     * 通过角色的id查询出对应的菜单信息
     * @param id
     * @return
     */
    List<Menu> findMenuByRole(Integer id);

    /**
     * 得到所有的菜单信息
     * @return
     */
    List<Menu> getMenuAll();
}
