package com.cdtu.yz.service.impl;

import cn.hutool.core.date.DateUtil;
import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.dao.RecruitDao;
import com.cdtu.yz.entity.Recruit;
import com.cdtu.yz.service.AdverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: An
 * @Date: 2019/7/2 10:21
 * @Version 1.0
 */
@Service
public class AdverServiceImpl implements AdverService {

    @Autowired
    RecruitDao recruitDao;

    /**
     *
     * @param pageUtil
     * @return
     */
    @Override
    public PageUtil getAdverPage(PageUtil pageUtil) {
        // 查询总的记录数
        pageUtil.setTotalCount(recruitDao.getAdeverCount());  // 总数

        // 查询当前页的数据
        pageUtil.setData(recruitDao.getAdverPage(pageUtil));

        return pageUtil;
    }

    @Override
    public boolean addAdver(Recruit recruit) {
        // 设置一个时间戳，作为创建时间
        recruit.setCreateTime(DateUtil.now());

        return recruitDao.insert(recruit);
    }

    @Override
    public Recruit getAdverByParam(String param) {
        return recruitDao.getRecruitByTitle(param);
    }

    @Override
    public Recruit getRecruitById(Integer id) {
        return recruitDao.getRecruitById(id);
    }

    @Override
    public boolean updateRecruit(Recruit recruit) {
        return recruitDao.updateRecruit(recruit);
    }

    @Override
    public boolean delRecruit(Integer id) {
        return recruitDao.delRecruitById(id);
    }

    @Override
    public void incrementCount(Integer id) {
        recruitDao.incrementCount(id);
    }

    @Override
    public List<Recruit> getAdverList() {
        // 获取数据库中人员招聘信息的总条数
        int count = recruitDao.getAdeverCount();
        // 获取数据库中最后5条数据，即最新的五条数据
        count = count -6 > 0 ? count -6 : 0;
        return recruitDao.getRecruitList(count);
    }
}
