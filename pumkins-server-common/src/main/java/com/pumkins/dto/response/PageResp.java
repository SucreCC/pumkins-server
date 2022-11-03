package com.pumkins.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author: dengKai
 * @date: 2022/02/06 12:28
 * @description:
 */
@Data
@Accessors(chain = true)
public class PageResp<T> extends JsonResp<T> {

    private long total;
    @JsonProperty(value = "list")
    private T data;
    private Boolean hasMore = Boolean.FALSE;
    private Map<String, String> extparams;


    public PageResp() {
        super(SUCCESS_STATUS, (T) Collections.<T>emptyList());
    }
    public PageResp(long total, T data) {
        super(SUCCESS_STATUS, data);
        this.total = total;
    }

    public PageResp(int status, T data, String errorMsg) {
        super(status, data, errorMsg);
    }

    public static PageResp emptyResult() {
        return new PageResp(0, Collections.EMPTY_LIST);
    }

    public static <T> PageResp<T> success(long total, T data) {
        return new PageResp(total, data);
    }

    public static <T> PageResp<List<T>> success(PageWrap<T> pageWrap) {
        return new PageResp(pageWrap.getTotal(), pageWrap.getList());
    }

    public static <T> PageResp<T> success(long total, Boolean hasMore, T data) {
        PageResp<T> pageResp = new PageResp(total, data);
        pageResp.setHasMore(hasMore);
        return pageResp;
    }

    public static <T> PageResp<T> success(long total, T data, Map<String, String> extparams) {
        PageResp<T> pageResp = new PageResp(total, data);
        pageResp.setExtparams(extparams);
        return pageResp;
    }

    public static PageResp fail(String errorMsg) {
        return fail(DEFAULT_FAIL_STATUS, errorMsg);
    }

    public static PageResp fail(int status, String errorMsg) {
        Assert.isTrue(status != SUCCESS_STATUS, "Must be not success status: " + status);
        return new PageResp(status, null, errorMsg);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Map<String, String> getExtparams() {
        return extparams;
    }

    public void setExtparams(Map<String, String> extparams) {
        this.extparams = extparams;
    }
}

