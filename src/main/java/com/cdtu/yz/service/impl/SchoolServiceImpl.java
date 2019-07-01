package com.cdtu.yz.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.dao.SchoolDao;
import com.cdtu.yz.entity.School;
import com.cdtu.yz.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/28 9:41
 * @Version 1.0
 */
@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolDao schoolDao;

    @Override
    public List<School> getSchoolAll() {
        return schoolDao.getSchoolAll();
    }

    @Override
    public School getSchoolById(Integer id) {
        return decode(schoolDao.getSchoolById(id));
    }

    @Override
    public PageUtil getSchoolPage(PageUtil pageUtil) {

        // 查询总的记录数
        pageUtil.setTotalCount(schoolDao.getSchoolCount());  // 总数

        // 查询当前页的数据
        pageUtil.setData(schoolDao.getSchoolPage(pageUtil));

        return pageUtil;
    }

    @Override
    public School getSchoolByName(String schoolName) {
        return decode(schoolDao.getSchoolByName(schoolName));
    }

    @Override
    public boolean isExist(String schoolName) {
        if (null != schoolDao.getSchoolByName(schoolName)){
            return true;
        }
        return false;
    }

    @Override
    public boolean addSchool(School school) {
        // 生成一个时间戳
        school.setCreateTime(DateUtil.now());

        return schoolDao.addSchool(encode(school));
    }

    @Override
    public School editSchool(School school) {

        if (schoolDao.updateSchool(encode(school))){
            return school;
        }
        return null;

    }

    /**
     * 静态方法
     * 用于对school中profile和history信息进行编码
     * @param school
     * @return
     */
    public static School encode(School school){
        // 对高校简介和历史信息进行编码
        school.setProfile(Base64.encode(school.getProfile()));
        school.setHistory(Base64.encode(school.getHistory()));
        return school;
    }

    /**
     * 静态方法
     * 用于对school中profile和history信息进行解码
     * @param school
     * @return
     */
    public static School decode(School school){
        // 数据解码
        school.setProfile(Base64.decodeStr(school.getProfile()));
        school.setHistory(Base64.decodeStr(school.getHistory()));
        return school;
    }


}
