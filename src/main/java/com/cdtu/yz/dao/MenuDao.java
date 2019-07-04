package com.cdtu.yz.dao;

import com.cdtu.yz.entity.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 23:33
 * @Version 1.0
 */
@Component
public interface MenuDao {

    /**
     * 通过角色的id信息查询出对应的管理员菜单信息
     * @param roleId
     * @return
     */
    List<Menu> selectMenuByRole(Integer roleId);

    /**
     * 返回所有的菜单信息
     * @return
     */
    List<Menu> getMenuAll();
}
