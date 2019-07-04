package com.cdtu.yz.entity;

import lombok.Data;

/**
 * Policy  实体类
 * @Author: An
 * @Date: 2019/6/27 18:03
 * @Version 1.0
 */
@Data
public class Policy {
    private Integer id;
    private String title;  // 文章标题
    private String editor;  // 文章编辑者
    private String content;  // 文章内容
    private String filePath;  // 文件路径
    private String createTime;  // 创建时间
    private int count;  // 文章阅读量
    private String status;  // 状态属性
    private String reserve;  // 备用属性
}
