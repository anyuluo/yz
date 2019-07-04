package com.cdtu.yz.service;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Need;

import java.util.List;

public interface NeedService {
    /**
     * 需求页面分页的实现
     * @param pageUtil
     * @return
     */
    PageUtil getNeedPage(PageUtil pageUtil);

    /**
     * 需求标题是否存在
     * @param title
     * @return
     */
    boolean isExist(String title);

    /**
     * 需求信息添加到数据库
     * @param need
     * @return
     */
    boolean addNeed(Need need);

    /**
     * 通过需求名称查询
     * @param title
     * @return
     */
    Need getNeedByTitle(String title);

    /**
     * 修改需求
     * @param need
     * @return
     */

    boolean editNeed(Need need);

    Need getNeedById(Integer id);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delNeed(Integer id);

    /**
     * 修改需求阅读量
     * @param id
     */
    void incrementCount(Integer id);

    /**
     * 获取援藏需求中5条最新的消息
     * @return
     */
    List<Need> getNeedList();
}
