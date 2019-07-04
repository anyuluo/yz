package com.cdtu.yz.dao;

import com.cdtu.yz.entity.RoleItem;
import org.springframework.stereotype.Component;

/**
 * @Author: An
 * @Date: 2019/7/3 11:35
 * @Version 1.0
 */
@Component
public interface RoleItemDao {

    /**
     * 通过角色id删除角色所拥有的所有的权限信息
     * @param roleId
     * @return
     */
    boolean delRoleByRoleId(Integer roleId);

    /**
     * 通过角色id信息向数据库中添加角色的权限信息
     * @param roleItem
     * @return
     */
    boolean insetByRoleId(RoleItem roleItem);
}
