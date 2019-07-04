package com.cdtu.yz.common;


import java.util.List;

/**
 * 分页工具类
 * @Author: An
 * @Date: 2019/6/28 12:47
 * @Version 1.0
 */
public class PageUtil {

    // 总记录数
    private Integer totalCount;
    // 每页数据量
    private Integer pageSize = 3;  // 设置页面的数据量为3
    // 总页数
    private Integer totalPage;
    // 当前页
    private Integer currPage = 1;
    // 开始查询的位置
    private Integer start = 0;
    // 数据
    private List<?> data;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 重写get方法计算总的页数
     * @return
     */
    public Integer getTotalPage() {

        return (this.totalCount % this.pageSize) == 0 ? (this.totalCount / this.pageSize) : (this.totalCount / this.pageSize) + 1;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    /**
     * 重写get方法，计算查询开始位置
     * @return
     */
    public Integer getStart() {
        return (this.currPage - 1) * this.pageSize;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
