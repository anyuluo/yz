package com.cdtu.yz.service;


import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Menu;
import com.cdtu.yz.entity.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/27 13:15
 * @Version 1.0
 */

public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 通过用户id查询用户信息
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 通过姓名查询用户
     * @param userName
     * @return
     */
    User getUserByName(String userName);

    /**
     * 返回所有的用户
     * @return
     */
    List<User> getUserAll();

    /**
     * 用户分页
     * @param pageNum
     * @return
     */
    PageUtil getUserPage(PageUtil pageNum);

    /**
     * 用户是否存在，存在返回true，不存在返回false
     * @param userName
     * @return
     */
    boolean isExist(String userName);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 通过di删除对应的用户
     * @param id
     * @return
     */
    boolean delUser(Integer id);

    /**
     * 获取用户菜单信息
     * @param user
     * @return
     */
    List<Menu> getUserMenu(User user);
}
