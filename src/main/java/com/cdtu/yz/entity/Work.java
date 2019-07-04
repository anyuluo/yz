package com.cdtu.yz.entity;

import lombok.Data;

/**
 * Work  工作动态实体类
 * @Author: An
 * @Date: 2019/6/27 18:01
 * @Version 1.0
 */
@Data
public class Work {
    private Integer id;
    private String title;  // 文章标题
    private String editor;  // 文章编辑者
    private String content;  // 文章内容
    private String schoolName;  // 学校
    private String history_go;  // 文章内容
    private String createTime;  // 创建时间
    private Integer count;  // 文章阅读量
    private String status;  // 状态属性
    private String reserve;  // 备用属性
    private String editTime;  // 修改时间

//    public String toString(){
//        return "[id=" + id + ",title=" + title +"]";
//    }
}
