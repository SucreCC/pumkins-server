package com.pumkins.resp;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.util.Assert;

/**
 * @author: dengKai
 * @date: 2022/02/06 11:57
 * @description:
 */
@Data
@Accessors(chain = true)
public class JsonResp<T> {
    public static final int SUCCESS_STATUS = 0;
    public static final int DEFAULT_FAIL_STATUS = -1;
    public static final String OK = "ok";

    /**
     * 0-成功，其它-失败
     */
    private int status;

    private T data;

    private String errorMsg;

    public JsonResp() {

    }

    public JsonResp(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public JsonResp(int status, T data, String errorMsg) {
        this.status = status;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public static JsonResp<String> success() {
        return new JsonResp(SUCCESS_STATUS, OK);
    }

    public static <T> JsonResp<T> success(T data) {
        return new JsonResp(SUCCESS_STATUS, data);
    }

    public static JsonResp fail(String errorMsg) {
        return fail(DEFAULT_FAIL_STATUS, errorMsg);
    }

    public static <T> JsonResp<T> fail(T data, String errorMsg) {
        return new JsonResp(DEFAULT_FAIL_STATUS, data, errorMsg);
    }

    public static JsonResp fail(int status, String errorMsg) {
        Assert.isTrue(status != SUCCESS_STATUS, "Must be not success status: " + status);
        return new JsonResp(status, null, errorMsg);
    }
}

