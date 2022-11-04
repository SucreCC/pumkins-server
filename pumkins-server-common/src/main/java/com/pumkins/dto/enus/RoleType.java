package com.pumkins.dto.enus;

/**
 * @Author: dengKai
 * @Date: 2022-11-04-19-18
 * @Description: TODO
 */

public enum RoleType implements BaseEnum {
    HOST(0, "host", "host"),
    USER(1, "user", "user"),
    NORMAL(2, "normal", "normal");


    private Integer index;
    private String name;
    private String message;

    RoleType(Integer index, String name, String message) {
        this.index = index;
        this.name = name;
        this.message = message;
    }

    @Override
    public Integer getIndex() {
        return index;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
