package com.cdtu.yz.entity;

import lombok.Data;

/**
 * @Author: An
 * @Date: 2019/7/2 22:33
 * @Version 1.0
 */
@Data
public class Role {
    private Integer id;
    private String roleName;
    private String description;  // 描述
    private String remark;  // 备注
}
