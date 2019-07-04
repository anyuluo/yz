package com.cdtu.yz.entity;

import lombok.Data;

/**
 * Menu  菜单实体类
 * @Author: An
 * @Date: 2019/7/2 19:41
 * @Version 1.0
 */
@Data
public class Menu {
    private Integer id;
    private String menuType;  // 菜单类型
    private String menuName;  //  菜单名称
    private String url;  // 菜单链接
}
