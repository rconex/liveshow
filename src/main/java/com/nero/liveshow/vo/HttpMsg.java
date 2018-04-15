package com.nero.liveshow.vo;

public class HttpMsg {

    private boolean success;

    private String msg;

    public HttpMsg() {
        this(true, "success");
    }

    public HttpMsg(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
}
