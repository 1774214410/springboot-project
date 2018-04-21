package com.example.demo05.utils;

/**
 * @classDescription:    枚举类
 * Created by gaomin on 2016/8/6.
 */

public enum ResultCode {
    SUCCESS(0, "成功"),
    FAILURE(1,"失败"),
    FINSHED(0, "finshed"),
    Token_FAIL(1, "令牌验证"),
    EXCEPTION(1, "发生异常");



    private int code;
    private String msg;

    ResultCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
