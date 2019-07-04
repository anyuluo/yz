package com.cdtu.yz.dao;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.School;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/28 9:43
 * @Version 1.0
 */
@Component
public interface SchoolDao {

    /**
     * 添加学校信息
     * @param school
     */
    boolean addSchool(School school);

    /**
     * 通过学校id查询学校信息
     * @param id
     * @return
     */
    School getSchoolById(Integer id);

    /**
     * 通过高校名称返回高校信息
     * @param schoolName
     * @return
     */
    School getSchoolByName(String schoolName);

    /**
     * 获取所有的学校信息
     * @return
     */
    List<School> getSchoolAll();

    /**
     * 返回用户记录的总条数
     * @return
     */
    Integer getSchoolCount();

    /**
     * 查询当前页面的信息
     * @return
     */
    List<School> getSchoolPage(PageUtil pageUtil);

    /**
     * 更新学校信息
     * @param school
     * @return
     */
    boolean updateSchool(School school);

    /**
     * 通过id删除学校详细信息
     * @param id
     * @return
     */
    boolean delSchool(Integer id);

}
