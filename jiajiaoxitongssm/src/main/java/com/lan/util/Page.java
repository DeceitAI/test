package com.lan.util;

import java.io.Serializable;

public class Page implements Serializable {
    private static final long serialVersionUID = 1L;

    private int pageIndex = 1;      //当前页面

    private int pageSize = 10;     //每页显示的数量

    private int totalCount;     //总记录数

    private int totalPageCount;      //总页数

    private int startPos;        //开始位置，从0开始

    private boolean hasFrist;      //是否有首页

    private boolean hasPre;     //是否有前一页

    private boolean hasNext;     //是否有后一页

    private boolean hasLast;     //是否有尾页

    private String t_class;
    private String t_kemu;
    private String t_sex;

    /**
     * 通过构造函数，传入总记录数和当前页
     *
     * @param pageIndex
     * @param totalCount
     */
    public Page(int pageIndex, int totalCount) {
        super();
        this.pageIndex = pageIndex;
        this.totalCount = totalCount;
    }

    public String getT_class() {
        return t_class;
    }

    public void setT_class(String t_class) {
        this.t_class = t_class;
    }

    public String getT_kemu() {
        return t_kemu;
    }

    public void setT_kemu(String t_kemu) {
        this.t_kemu = t_kemu;
    }

    public String getT_sex() {
        return t_sex;
    }

    public void setT_sex(String t_sex) {
        this.t_sex = t_sex;
    }

    //获取总页数
    public int getTotalPageCount() {
        totalPageCount = getTotalCount() / getPageSize();
        return (totalCount %pageSize == 0) ? totalPageCount : totalPageCount + 1;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getpageIndex() {
        return pageIndex;
    }

    public void setpageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
/*

    //取得选择记录的初始位置
    public int getStartPos() {
        return (pageIndex - 1) * pageSize;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    //判断是否有第一页
    public boolean isHasFrist() {
        return (pageIndex == 1) ? false : true;
    }

    public void setHasFrist(boolean hasFrist) {
        this.hasFrist = hasFrist;
    }

    //如果有首页就有前一页
    public boolean isHasPre() {
        return isHasFrist() ? true : false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    //如果有尾页就有下一页
    public boolean isHasNext() {
        return isHasNext() ? true : false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    //判断是否有尾页
    public boolean isHasLast() {
        return (pageIndex == getTotalCount()) ? false : true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }
*/

}