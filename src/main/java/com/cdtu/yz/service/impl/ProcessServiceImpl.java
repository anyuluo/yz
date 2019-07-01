package com.cdtu.yz.service.impl;

import cn.hutool.core.date.DateUtil;
import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.dao.ProcessDao;
import com.cdtu.yz.entity.Process;
import com.cdtu.yz.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: An
 * @Date: 2019/6/30 23:31
 * @Version 1.0
 */
@Service
public class ProcessServiceImpl implements ProcessService {


    @Autowired
    ProcessDao processDao;

    @Override
    public PageUtil getProcessPage(PageUtil pageUtil) {
// 查询总的记录数
        pageUtil.setTotalCount(processDao.getProcessCount());  // 总数

        // 查询当前页的数据
        pageUtil.setData(processDao.getProcessPage(pageUtil));

        return pageUtil;
    }


    @Override
    public boolean addProcess(Process process) {
        //设置时间戳
        process.setCreateTime(DateUtil.now());

        return processDao.addProcess(process);
    }

    @Override
    public Process getProcessById(Integer id) {
        return processDao.getProcessById(id);
    }
}
