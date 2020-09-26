package com.pilipili.server.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDto<T> {

    /**
     * 当前页码
     */
    protected Integer page;

    /**
     * 每页条数
     */
    protected Integer size;

    /**
     * 总条数
     */
    protected Long total;

    protected List<T> list;

}
