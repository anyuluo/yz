package com.cdtu.yz.service.impl;

import cn.hutool.core.date.DateUtil;
import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.dao.PolicyDao;
import com.cdtu.yz.entity.Policy;
import com.cdtu.yz.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/30 13:46
 * @Version 1.0
 */
@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    PolicyDao policyDao;

    @Override
    public Policy getPolicyById(Integer integer) {
        return policyDao.getPolicyById(integer);
    }

    @Override
    public PageUtil getPolicys(String param) {
        PageUtil pageUtil = new PageUtil();
        List<Policy> policys = policyDao.getPolicysByParam(param);
        pageUtil.setData(policys);  // 数据
        pageUtil.setTotalCount(policys.size());  // 设置总的记录条数
        pageUtil.setTotalPage(1);  // 设置总的页数为1

        return pageUtil;
    }

    @Override
    public boolean addPolicy(Policy policy) {
        //设置时间戳
        policy.setCreateTime(DateUtil.now());
        policy.setCount(0);  // 初始化浏览量为0
        return policyDao.addPolicy(policy);
    }

    @Override
    public boolean editPolicy(Policy policy) {
        //设置时间戳
        policy.setCreateTime(DateUtil.now());
        return policyDao.editPolicy(policy);
    }

    @Override
    public PageUtil getPolicyPage(PageUtil pageUtil) {
        // 查询总的记录数
        pageUtil.setTotalCount(policyDao.getPolicyCount());  // 总数

        // 查询当前页的数据
        pageUtil.setData(policyDao.getPolicyPage(pageUtil));

        return pageUtil;
    }

    @Override
    public void incrementCount(String fileName) {
        policyDao.incrementCount(fileName);
    }
}
