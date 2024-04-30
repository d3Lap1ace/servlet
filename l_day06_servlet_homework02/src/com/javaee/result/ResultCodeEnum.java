package com.javaee.result;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 13:19 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


/**
 * 业务含义和状态码对应关系的枚举
 */
public enum ResultCodeEnum {
    SUCCESS(200,"success"),
    USERNAME_ERROR(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed")
    ;
    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
