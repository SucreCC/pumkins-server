package com.pumkins.dto.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author: dengKai
 * @date: 2022/02/06 12:26
 * @description:
 */
@Data
@Accessors(chain = true)
public class PageWrap<T> {
    // 总条数
    private long total;
    // 当前页数据列表
    private List<T> list;
    // 扩展参数
    private Map<String, String> extparams;

    public static <T> PageWrap<T> genPageWrap(long total, List<T> list) {
        return new PageWrap(total, list);
    }

    public static <T> PageWrap<T> empty() {
        return new PageWrap();
    }

    public PageWrap() {
        this.list = Collections.emptyList();
    }

    public PageWrap(long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Map<String, String> getExtparams() {
        return extparams;
    }

    public void setExtparams(Map<String, String> extparams) {
        this.extparams = extparams;
    }
}
