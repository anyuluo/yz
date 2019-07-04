package com.cdtu.yz.dao;

import com.cdtu.yz.common.PageUtil;
import com.cdtu.yz.entity.Process;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @Author: An
 * @Date: 2019/6/30 23:35
 * @Version 1.0
 */
@Component
public interface ProcessDao {
    /**
     * 返回用户记录的总条数
     * @return
     */
    int getProcessCount();

    /**
     * 查询当前页面的信息
     * @return
     */
    List<Process> getProcessPage(PageUtil pageUtil);

    /**
     * 添加援藏高校流程信息
     * @param process
     * @return
     */
    boolean addProcess(Process process);

    /**
     * 通过id查询政策详细信息
     * @param id
     * @return
     */
    Process getProcessById(Integer id);

    /**
     * 更新路线信息
     * @param process
     * @return
     */
    boolean updateProcess(Process process);

    /**
     * 通过id删除路线的详细信息
     * @param id
     * @return
     */
    boolean delProcess(Integer id);
}
