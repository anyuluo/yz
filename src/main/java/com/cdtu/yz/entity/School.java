package com.cdtu.yz.entity;

import lombok.Data;

/**
 * School  高校实体类
 * @Author: An
 * @Date: 2019/6/27 16:54
 * @Version 1.0
 */
@Data
public class School {
    private Integer id;
    private String schoolName;
    private String isNeed;  // 是否需要援助
    private String isGo;  // 是否愿意前往援助
    private String profile;  // 高校简介
    private String history;  // 援藏历史
    private String createTime;  // 创建时间
    private String reserve;  // 备用字段
}
