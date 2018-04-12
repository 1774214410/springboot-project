package com.example.demo05.utils;

import java.io.Serializable;

/**
 * @classDescription:
 * Created by gaomin on 2016/8/6.
 */

public class JsonResult implements Serializable{

    private int code;
    private String msg;
    private Object data;


    public JsonResult(ResultCode resultCode) {
        this.setCode(resultCode.getCode());
        this.setMsg(resultCode.getMsg());
    }

    public JsonResult(ResultCode resultCode, Object object) {
        this.setCode(resultCode.getCode());
        this.setMsg(resultCode.getMsg());
        this.setData(object);
    }

    public JsonResult(ResultCode resultCode, String msg) {
        this.setCode(resultCode.getCode());
        this.setMsg(msg);
    }

    public JsonResult(ResultCode resultCode, String msg, Object data) {
        this.setCode(code);
        this.setMsg(resultCode.getMsg());
        this.setData(data);
    }

    public JsonResult(int code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }
    public JsonResult(){}


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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
