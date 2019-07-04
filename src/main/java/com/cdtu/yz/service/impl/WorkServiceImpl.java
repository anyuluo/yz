package com.cdtu.yz.service.impl;


import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import com.cdtu.yz.common.PageUtil;

import com.cdtu.yz.dao.WorkDao;
import com.cdtu.yz.entity.Work;
import com.cdtu.yz.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkDao workDao;

    @Override
    public PageUtil getWorkPage(PageUtil pageUtil) {

        // 查询总的记录数
        pageUtil.setTotalCount(workDao.getWorkCount());  // 总数

        // 查询当前页的数据
        pageUtil.setData(workDao.getWorkPage(pageUtil));

        return pageUtil;
    }

    @Override
    public Work getWorkById(Integer id) {
        return workDao.getWorkById(id);
    }

    @Override
    public boolean delWork(Integer id) {

        return  workDao.delWork(id);
    }

    @Override
    public boolean addWork(Work work) {
        // 生成一个时间戳
        work.setCreateTime(DateUtil.now());

        // 初始化阅读量count为0
        work.setCount(0);

        return workDao.addWork(work);
    }

    @Override
    public Work editWork(Work work) {
//        workDao.editWork(work);
//        return null;
        // 生成一个时间戳
       work.setEditTime(DateUtil.now());

        if (workDao.editWork(work)){

            return work;
        }
        return null;
    }


    @Override
    public Work getWorkByName(String title) {
        Work work = workDao.getWorkByName(title);

        if(work == null) return null;

        return work;

    }

    /**
     * 判断工作动态标题是否存在
     * @param title
     * @return
     */
    @Override
    public boolean isExist(String title) {
        if (null != workDao.getWorkByName(title))
        {
            return true;
        }
        return false;
    }


    /**
     * 静态方法
     * 用于对school中profile和history信息进行编码
     * @param work
     * @return
     */
    public static Work encode(Work work){
        // 对高校简介和历史信息进行编码
        work.setContent(Base64.encode(work.getContent()));
        work.setHistory_go(Base64.encode(work.getHistory_go()));

        return work;
    }

    /**
     * 静态方法
     * 用于对school中profile和history信息进行解码
     * @param work
     * @return
     */
    public static Work decode(Work work){
        // 数据解码
        work.setContent(Base64.decodeStr(work.getContent()));
        work.setHistory_go(Base64.decodeStr(work.getHistory_go()));

        return work;
    }

    @Override
    public void incrementCount(Integer id) {
        workDao.incrementCount(id);
    }
}
