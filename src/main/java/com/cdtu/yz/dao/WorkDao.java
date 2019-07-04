package com.cdtu.yz.dao;


import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.School;
import com.cdtu.yz.entity.Work;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WorkDao {



    /**
     * 返回工作动态记录的总条数
     * @return
     */
    Integer getWorkCount();

    /**
     * 查询当前页面的信息
     * @return
     */
    List<Work> getWorkPage(PageUtil pageUtil);

    /**
     * 通过学校id查询学校信息
     * @param id
     * @return
     */
    Work getWorkById(Integer id);





    /**
     * 删除的信息
     * @param id
     * @return
     */
    boolean delWork(Integer id);



    /**
     * 插入工作信息
     * @param work
     * @return
     */
    boolean addWork(Work work);


//修改工作动态
boolean editWork(Work work);

    /**
     * 根据标题信息返回工作动态
     * @param title
     * @return
     */
    Work getWorkByName(String title);


    /**
     * 修改阅读量
     * @param id
     */
    void incrementCount(Integer id);




}
