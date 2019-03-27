package com.hwua.jsp.util;

import java.util.List;

public class PageUtil<T> {
    private Integer page;
    private Integer pageSize;
    private Integer total;
    private Integer prev;
    private Integer next;
    private Integer end;
    private List<T> data;

    public PageUtil(Integer page, Integer pageSize, Integer total, List<T> data) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
        this.end=total%pageSize==0?(total/pageSize):((total/pageSize)+1);
        this.prev=page==1?1:(page-1);
        this.next=page==end?end:(page+1);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPrev() {
        return prev;
    }

    public void setPrev(Integer prev) {
        this.prev = prev;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", prev=" + prev +
                ", next=" + next +
                ", end=" + end +
                ", data=" + data +
                '}';
    }
}
