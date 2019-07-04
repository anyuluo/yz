package com.cdtu.yz.service;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Policy;

/**
 * @Author: An
 * @Date: 2019/6/30 13:44
 * @Version 1.0
 */
public interface PolicyService {

    /**
     * 通过id获取政策信息
     * @param integer
     * @return
     */
    Policy getPolicyById(Integer integer);

    /**
     * 政策分页实现
     * @param pageUtil
     * @return
     */
    PageUtil getPolicyPage(PageUtil pageUtil);

    /**
     * 添加政策信息
     * @param policy
     * @return
     */
    boolean addPolicy(Policy policy);

    /**
     * 根据相关的参数信息匹配出相关的政策信息
     * @param param
     * @return
     */
    PageUtil getPolicys(String param);

    /**
     * 修改政策信息
     * @param policy
     * @return
     */
    boolean editPolicy(Policy policy);

    /**
     * 修改政策信息的阅读量
     * @param id
     */
    void incrementCount(String id);
}
