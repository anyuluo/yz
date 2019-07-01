package com.cdtu.yz.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.dao.SchoolDao;
import com.cdtu.yz.dao.UserDao;
import com.cdtu.yz.entity.User;
import com.cdtu.yz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: An
 * @Date: 2019/6/27 13:28
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    SchoolDao schoolDao;


    @Override
    public boolean login(String username, String password) {
        // 通过用户名查询用户密码
        User user = userDao.getUserByName(username);

        //对密码进行md5加密
        password = SecureUtil.md5(password);

        if (null != user && password.equals(user.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public boolean delUser(Integer id) {
        //查询需要删除的用户信息
        User user = userDao.getUserById(id);
        // 将用户需要删除的数据放到数据库表user_del中
        if (userDao.insertDel(user)){
            // 删除数据
            userDao.delUser(user);
            return true;
        }
        return false;
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public PageUtil getUserPage(PageUtil pageUtil) {

        // 查询总的记录数
        pageUtil.setTotalCount(userDao.getUserCount());  // 总数

        // 查询当前页的数据
        pageUtil.setData(userDao.getUserPage(pageUtil));

        return pageUtil;
    }

    @Override
    public boolean addUser(User user) {
        // 对用户密码进行加密
        user.setPassword(SecureUtil.md5(user.getPassword()));

        // 通过高校id查询所属学校
        // schoolDao.getSchoolById(user.getSchoolId());
        user.setSchoolName(schoolDao.getSchoolById(user.getSchoolId()).getSchoolName());
        // 生成一个时间戳
        user.setCreateTime(DateUtil.now());
        // 将用户数据交给dao层
        userDao.insert(user);
        return false;
    }

    @Override
    public List<User> getUserAll() {
        return userDao.getUserAll();
    }

    @Override
    public boolean isExist(String userName) {

        User user = userDao.getUserByName(userName);
        if (null != user) {
            return true;
        } else {
            return false;
        }
    }
}
