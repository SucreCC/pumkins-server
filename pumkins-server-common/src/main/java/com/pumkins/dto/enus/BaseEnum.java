package com.pumkins.dto.enus;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;

/**
 * 枚举基础信息
 * @author dengkai
 * @date 2019/12/2 17:30
 */
@JsonSerialize(using = EnumSerializer.class)
public interface BaseEnum {
    /**
     * 索引
     * @return
     */
    Integer getIndex();

    /**
     * 名称
     * @return
     */
    String getName();

    /**
     * 信息
     * @return
     */
    String getMessage();
}
