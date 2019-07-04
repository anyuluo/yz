package com.cdtu.yz.entity;

import lombok.Data;

/**
 * Auth 实体类
 * 权限管理实体类
 *
 * @Author: An
 * @Date: 2019/6/27 18:13
 * @Version 1.0
 */
@Data
public class Auth {//implements GrantedAuthority {
    private Integer id;
    private String roleName;  // 角色名称
    private String authority;  // 权限管理权限
    private String role;  // 角色管理权限
    private String school;  // 学校管理权限
    private String need;  // 需求管理权限
    private String route;  //  路线管理权限
    private String work;  //  工作动态管理权限
    private String policy;  // 政策管理权限
    private String person;  // 人员招聘管理权限
    private String talent;  // 人才引进夫管理权限
    private String reserve;  // 备用字段
}
