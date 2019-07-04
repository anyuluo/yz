package com.cdtu.yz.service;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.School;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/28 9:39
 * @Version 1.0
 */
public interface SchoolService {

    /**
     * 更具学校部分信息返回学校详细信息
     * @param schoolName
     * @return
     */
    School getSchoolByName(String schoolName);

    /**
     * 通过id返回学校详细信息
     * @param id
     * @return
     */
    School getSchoolById(Integer id);

    /**
     * 获取所有的学校信息
     * @return
     */
    List<School> getSchoolAll();

    /**
     * 编辑学校信息
     *
     * 学校存在时更新学校信息
     * @param school
     * @return
     */
    School editSchool(School school);

    /**
     * 学校页面分页的实现
     * @param pageUtil
     * @return
     */
    PageUtil getSchoolPage(PageUtil pageUtil);

    /**
     * 添加高校信息
     * @param school
     * @return
     */
    boolean addSchool(School school);

    /**
     * 高校是否存在，存在返回true，不存在返回false
     * @param schoolName
     * @return
     */
    boolean isExist(String schoolName);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    boolean delSchool(Integer id);
}
