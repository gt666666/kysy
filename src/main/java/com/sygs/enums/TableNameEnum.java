package com.sygs.enums;

import lombok.Getter;

@Getter
public enum TableNameEnum {
    /**
     * 数据库表
     */
    MMEM(5014, "Mmem"),
    MEM(5013, "Mem");
    private Integer code;
    private String message;

    TableNameEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}