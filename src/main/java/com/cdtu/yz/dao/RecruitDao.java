package com.cdtu.yz.dao;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Recruit;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 10:22
 * @Version 1.0
 */
@Component
public interface RecruitDao {

    /**
     *
     * @return
     */
    Integer getAdeverCount();

    /**
     *
     * @return
     */
    List<Recruit> getAdverPage(PageUtil pageUtil);

    /**
     * 添加人才引进信息
     * @param recruit
     * @return
     */
    boolean insert(Recruit recruit);

    /**
     * 根据标题title查询人才引进相关信息
     * @param title
     * @return
     */
    Recruit getRecruitByTitle(String title);

    /**
     * 通过id查询人才引进相关的详细信息
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
     * 通过id删除人才引进的相关信息
     * @param id
     * @return
     */
    boolean delRecruitById(Integer id);

    /**
     * 修改人员招聘文章的阅读量
     * @param id
     */
    void incrementCount(Integer id);

    /**
     * 获取最新的人才招聘信息
     * @param count
     * @return
     */
    List<Recruit> getRecruitList(int count);
}
