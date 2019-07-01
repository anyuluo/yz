package com.cdtu.yz.entity;

import lombok.Data;

/**
 * Process 援藏流程实体类
 * @Author: An
 * @Date: 2019/6/30 23:22
 * @Version 1.0
 */
@Data
public class Process {
    private Integer id;
    private String processName;  // 流程名称
    private String schoolName;  // 高校名称
    private String detail;  // 流程详细
    private String createTime;  // 创建时间
    private String creator;  //创建者
    private String status;  // 状态
    private String reserve;  // 保留的字段
}
