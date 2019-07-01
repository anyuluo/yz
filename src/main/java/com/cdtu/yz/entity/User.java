package com.cdtu.yz.entity;

import lombok.Data;

/**
 * User 用户实体类
 *
 * @Author: An
 * @Date: 2019/6/27 13:13
 * @Version 1.0
 */
@Data
public class User {

    private Integer id;
    private String userName;
    private String password;
    private String sex;
    private String tel;
    private String qq;
    private String email;
    private Integer schoolId;  // 高校id
    private String schoolName;  // 高校名称
    private String role;  // 角色
    private String createTime;  // 创建时间
    private String creator;  // 创建者
    private String status;  // 状态
    private String reserve;  // 备用字段

}
