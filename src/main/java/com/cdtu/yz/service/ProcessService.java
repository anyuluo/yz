package com.cdtu.yz.service;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Process;

/**
 * @Author: An
 * @Date: 2019/6/30 23:31
 * @Version 1.0
 */
public interface ProcessService {

    /**
     * 返回当前指定页的援藏流程数据
     * @param pageUtil
     * @return
     */
    PageUtil getProcessPage(PageUtil pageUtil);

    /**
     * 添加路线信息
     * @param process
     * @return
     */
    boolean addProcess(Process process);

    /**
     * 通过政策id获取政策的相关信息
     * @param id
     * @return
     */
    Process getProcessById(Integer id);

}
