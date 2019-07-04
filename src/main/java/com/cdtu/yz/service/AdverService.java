package com.cdtu.yz.service;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Recruit;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 10:19
 * @Version 1.0
 */
public interface AdverService {

    /**
     * 页面分页的实现
     * @param pageUtil
     * @return
     */
    PageUtil getAdverPage(PageUtil pageUtil);


    /**
     *
     * @param recruit
     * @return
     */
    boolean addAdver(Recruit recruit);

    /**
     * 通过指定的参数查询人才招聘的相关信息
     * @param param
     * @return
     */
    Recruit getAdverByParam(String param);

    /**
     * 通过id查询人才引进相关信息
     * @param id
     * @return
     */
    Recruit getRecruitById(Integer id);

    /**
     * 更新人才引进相关信息
     * @param recruit
     * @return
     */
    boolean updateRecruit(Recruit recruit);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    boolean delRecruit(Integer id);

    /**
     * 修改人员招聘文章的阅读量
     * @param id
     */
    void incrementCount(Integer id);

    /**
     * 返回 5 条最新的人员招聘信息显示到首页
     * @return
     */
    List<Recruit> getAdverList();
}
