package com.cdtu.yz.entity;

import lombok.Data;

/**
 * Person 实体类
 * @Author: An
 * @Date: 2019/6/27 18:05
 * @Version 1.0
 */
@Data
public class Person {
    private Integer id;
    private String name;
    private String course;  // 援助课程
    private Integer schoolId;  // 高校id
    private String schoolName;  // 高校名称
    private String tel;  // 电话
    private String qq;  // qq号
    private String createTime;  // 创建时间
    private String status;  // 状态属性
    private String profile;  // 简介
    private String reserve;  // 备用属性
}
