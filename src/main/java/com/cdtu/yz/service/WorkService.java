package com.cdtu.yz.service;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.School;
import com.cdtu.yz.entity.Work;

public interface WorkService {


    /**
     * 工作状态页面分页的实现
     * @param pageUtil
     * @return
     */
    PageUtil getWorkPage(PageUtil pageUtil);

    //通过Id查询学校
    Work getWorkById(Integer id);

    /**
     * 通过id删除对应的工作动态
     * @param id
     * @return
     */
    boolean delWork(Integer id);

    /**
     * 添加工作动态
     * @param work
     * @return
     */
    boolean addWork(Work work);


    /**
     * 编辑工作动态
     *
     * @param work
     * @return
     */
    Work editWork(Work work);



    /**
     * 根据标题信息返回工作动态
     * @param title
     * @return
     */
    Work getWorkByName(String title);


    /**
     * 修改工作动态的阅读量
     * @param id
     */
    void incrementCount(Integer id);

    /**
     * 工作动态标题是否存在
     * @param title
     * @return
     */
    boolean isExist(String title);

}
