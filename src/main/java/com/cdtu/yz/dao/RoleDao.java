package com.cdtu.yz.dao;

import com.cdtu.yz.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 22:34
 * @Version 1.0
 */
@Component
public interface RoleDao {

    /**
     * 获取所有的角色信息
     * @return
     */
    List<Role> getRoleAll();

    /**
     *
     * @param id
     * @return
     */
    Role getRoleById(Integer id);

}
