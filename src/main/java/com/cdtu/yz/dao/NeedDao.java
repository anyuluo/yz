package com.cdtu.yz.dao;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Need;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface NeedDao {
    /**
     * 返回用户记录的总条数
     * @return
     */
    Integer getNeedCount();

    /**
     * 查询当前页面的信息
     * @return
     */
    List<Need> getNeedPage(PageUtil pageUtil);

    /**
     *通过title查询需求
     * @param title
     * @return
     */
    Need getNeedByTitle(String title);

    /**
     * 添加需求
     * @param encode
     * @return
     */

    boolean addNeed(Need encode);

    /**
     * 修改需求信息
     * @param need
     * @return
     */
    boolean updateNeed(Need need);

    Need getNeedById(Integer id);


    boolean delNeed(Integer id);

    /**
     * 修改需求文章的阅读量
     * @param id
     */
    void incrementCount(Integer id);

    /**
     * 获取数据库中的援藏需求的最新的五条数据
     * @param count
     * @return
     */
    List<Need> getNeedList(int count);
}
