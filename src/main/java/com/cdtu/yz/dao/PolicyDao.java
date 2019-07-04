package com.cdtu.yz.dao;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Policy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/30 13:47
 * @Version 1.0
 */
@Component
public interface PolicyDao {
    /**
     * 通过id获取政策信息
     * @param id
     * @return
     */
    Policy getPolicyById(Integer id);

    /**
     * 添加政策信息到数据库中
     * @param policy
     * @return
     */
    boolean addPolicy(Policy policy);

    /**
     * 查询政策记录的总条数
     * @return
     */
    int getPolicyCount();

    /**
     * 分页查询政策信息
     * @param pageUtil
     * @return
     */
    List<Policy> getPolicyPage(PageUtil pageUtil);

    /**
     * 修改政策相关信息
     * @param policy
     * @return
     */
    boolean editPolicy(Policy policy);

    /**
     * 通过参数模糊匹配政策相关数据
     * @param param
     * @return
     */
    List<Policy> getPolicysByParam(String param);

    /**
     * 修改政策相关文章的阅读量
     * @param fileName
     */
    void incrementCount(String fileName);
}
