package com.cdtu.yz.dao;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Menu;
import com.cdtu.yz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/27 13:14
 * @Version 1.0
 */
@Component
public interface UserDao {

    /**
     * 插入用户信息
     * @param user
     * @return
     */
    boolean insert(User user);

    /**
     * 通过姓名查询用户
     *
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 通过id查询用户信息
     * @param username
     * @return
     */
    User getUserById(Integer username);

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    List<User> getUserAll();

    /**
     * 返回用户记录的总条数
     * @return
     */
    int getUserCount();

    /**
     * 查询当前页面的信息
     * @return
     */
    List<User> getUserPage(PageUtil pageUtil);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 做用户的删除
     * 并不真实的删除数据，将原表中的数据放到user_del表中， 在删除原来的数据
     * @param user
     * @return
     */
    boolean delUser(User user);

    /**
     * 添加用户删除的信息
     * @param user
     * @return
     */
    boolean insertDel(User user);

    /**
     * 通过角色名称获取用户的菜单信息
     * @param role
     * @return
     */
    List<Menu> getMenuByRoleName(String role);

}
