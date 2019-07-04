package com.cdtu.yz.entity;

import lombok.Data;

/**
 * Need 实体类
 * 表示援藏需求
 * @Author: An
 * @Date: 2019/6/27 18:11
 * @Version 1.0
 */
@Data
public class Need {
    private Integer id;
    private String title;  // 文章标题
    private String editor;  // 文章编辑者
    private String urgent;//紧急状态
    private String content;  // 文章内容
    private String createTime;  // 创建时间
    private String editTime;  // 修改时间
    private Integer count;  // 文章阅读量
    private String schoolName;//学校名称
    private String status;  // 状态属性
    private String reserve;  // 备用属性
}
