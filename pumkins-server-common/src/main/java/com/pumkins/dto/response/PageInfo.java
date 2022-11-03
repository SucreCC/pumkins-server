package com.pumkins.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.Min;
import java.util.Map;

/**
 * @author: dengKai
 * @date: 2022/02/06 12:30
 * @description: TODO
 */

@Data
@Accessors(chain = true)
public class PageInfo<T> {

    private static final FastDateFormat fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    /** 页码：1 ~ n */
    @Min(1)
    private Integer pi;

    /** 每页大小 */
    @Min(1)
    private Integer ps;

    /** 查询参数 */
    private T params;

    /** 排序参数 */
    private Map<String, String> sorts;

    /** 是否分表 */
    @JsonIgnore
    private boolean isSharding;

    private boolean pager = false;// 判断是否来源于翻页，不重复查询总记录数

    public Integer getPi() {
        return pi;
    }

    public void setPi(Integer pi) {
        this.pi = pi;
    }

    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public Map<String, String> getSorts() {
        return sorts;
    }

    public void setSorts(Map<String, String> sorts) {
        this.sorts = sorts;
    }

    public boolean isPager() {
        return pager;
    }

    public void setPager(boolean pager) {
        this.pager = pager;
    }

    /**
     * mysql查询语法中 基于偏移量offset
     * query.setFirstResult() 使用
     */
    public Integer getOffset() {
        if (null == ps || null == pi) {
            return 0;
        } else {
            return ps * (pi - 1);
        }
    }

    /**
     * mysql查询语法中 Limit
     * query.setMaxResults() 使用
     */
    public Integer getLimit() {
        return ps;
    }



    /**
     * alais 前端参数从第一页开始
     * spring pageable 基于0页 所以减1
     * spring jpa 分页使用
     */
    public Pageable toPageabel() {
        return PageRequest.of(pi - 1, ps);
    }

    public Pageable toPageable() {
        return PageRequest.of(this.pi - 1, this.ps);
    }

    public <R> PageInfo<R> convert(){
        PageInfo<R> pageInfo = new PageInfo<>();
        pageInfo.setPi(pi);
        pageInfo.setPs(ps);
        pageInfo.setPager(pager);
        pageInfo.setSorts(sorts);
        return pageInfo;
    }

    public PageInfo() {
        this.pi = 1;
        this.ps = 10;
    }
}
