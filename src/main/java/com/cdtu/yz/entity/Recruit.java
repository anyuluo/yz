package com.cdtu.yz.entity;

import lombok.Data;

/**
 * Recruit  人员招聘实体类
 * @Author: An
 * @Date: 2019/6/27 16:59
 * @Version 1.0
 */

@Data
public class Recruit {
    private Integer id;
    private String title;  // 文章标题
    private String schoolName;  // 人员招聘高校
    private String editor;  // 文章编辑者
    private String content;  // 文章内容
    private String createTime;  // 创建时间
    private int count;  // 文章阅读量
    private String status;  // 状态属性
    private String reserve;  // 备用属性
}
