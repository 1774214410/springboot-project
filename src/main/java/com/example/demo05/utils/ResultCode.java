package com.example.demo05.utils;

/**
 * @classDescription:
 * Created by gaomin on 2016/8/6.
 */

public enum ResultCode {
    SUCCESS(0, "成功"),
    FINSHED(0, "finshed"),
    Token_FAIL(1, "令牌验证"),
    CODE_FAIL(1, "您的code未上传成功"),
    EXCEPTION(1, "发生异常"),
    YOU_HAVE_RIGSTER(1, "您的手机已经注册过了"),
    YOU_HAVE_APPLUY(0, "您已经报名本次马拉松活动了"),
    ERROR_NO_USER(1,"用户不存在"),
    HUMOR_IS_DELETE(1,"说说已经被删了"),
    XINGZHENG_NO_EXISTE(1,"您的行政跑未创建成功"),
    ERROR_NO_Comment(1,"您回复的评论不存在了被删了"),
    ERROR_NO_teamInfo(1,"团队已经不存在"),
    YOU_HAVE_JOIN(1,"您已经参加该团队了"),
    YOU_HAVE_TEAMXY_EXISTER(1,"改团队的坐标文本已经添加过了"),

    MARATHRON_NO_EXISTE(1,"马拉松不存在"),
    MARAMA_IS_FALSE(1,"马拉松活动失效"),
    MARATHON_HAVE_FINSHED(1,"您好，您的马拉松团队已经完成了目标！"),
    MARATHON_NOT_APPLUY(1,"您好，您未报名！"),
    MARATHON_NOT_START(1,"您好，马拉松未开始！"),
    MARATHON_HAVE_START(1,"您好，马拉松已经开始了！"),
    MARATHON_HAVE_END(1,"您好，马拉松已经结束了！"),
    MARATHON_NUMBER_END(1,"您好，马拉松人数已经超过上线！"),
    MARATHON_APPLUY_END(1,"您好，报名时间已过！"),
    MARATHON_APPLUY_NOPERMISSION(1,"您好，您没有报名权限，此活动只适用特定跑团！"),

    CODE_ERROR(1,"您输入的手机号或验证码错误"),
    CODE_SEND_FAIL(1,"验证码发送失败!"),
    CODE_INVALID(1,"验证码已失效!"),
    PHONE_BIND(1,"该手机号已被绑定过!"),
    PHONE_HAVING_REGISTE(1,"该手机号已经注册过,不能绑定"),
    PERSON_HAVE_FULL(2,"参赛人数已满");


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
